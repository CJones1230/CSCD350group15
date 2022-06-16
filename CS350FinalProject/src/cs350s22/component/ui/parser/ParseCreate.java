package cs350s22.component.ui.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cs350s22.component.sensor.A_Sensor;
import cs350s22.component.sensor.mapper.MapperEquation;
import cs350s22.component.sensor.mapper.MapperInterpolation;
import cs350s22.component.sensor.mapper.function.equation.EquationNormalized;
import cs350s22.component.sensor.mapper.function.equation.EquationPassthrough;
import cs350s22.component.sensor.mapper.function.equation.EquationScaled;
import cs350s22.component.sensor.mapper.function.interpolator.InterpolationMap;
import cs350s22.component.sensor.mapper.function.interpolator.InterpolatorLinear;
import cs350s22.component.sensor.mapper.function.interpolator.InterpolatorSpline;
import cs350s22.component.sensor.mapper.function.interpolator.loader.MapLoader;
import cs350s22.support.Filespec;
import cs350s22.support.Identifier;
import cs350s22.test.ActuatorPrototype;

public class ParseCreate {
	
	public static void initialCreate(String[] commandArray, A_ParserHelper parserHelper) throws IOException {

		switch (commandArray[1]) {

			case "actuator":
				getActuatorInfo(commandArray, parserHelper);
				break;

			case "mapper":
				getMapperInfo(commandArray, parserHelper);
				break;

			case "watchdog":
				ParseWatchdog.createWatchdog(commandArray, parserHelper);
				break;

			case "sensor":
				ParseSensor.createSensor(commandArray, parserHelper);
				break;

			case "reporter":
				ParseReporter.createReporter(commandArray, parserHelper);
				break;

		}// end switch

	}// end method



	public static void getActuatorInfo (String[] leftOver, A_ParserHelper parserHelper){
		String type = null;
		String actID = null;
		

		double leadin = 0.0, leadout = 0.0, relax = 0.0;
		int vL = 0, vMin= 0, vMax= 0, initial= 0, jerkLimit= 0;
		String[] sensorIDs = new String[1];
		List<Identifier> groups = new ArrayList<Identifier>();
		String[] groupIDS = new String[1];

		ArrayList<Identifier> sensorID = new ArrayList<Identifier>();
		if(leftOver[2].equalsIgnoreCase("LINEAR") || leftOver[2].equalsIgnoreCase("ROTARY")){
			type = leftOver[2]; // gets the type of actuator
			actID = leftOver[3]; // gets the name of the actuatoc
		}
		int pos1 = 4, pos3 = pos1;
		if(leftOver[4].equalsIgnoreCase("GROUP")) { // getting the name of all sensors
			int count = 0;
			int i = 1;
			while(!leftOver[pos1 + i].equalsIgnoreCase("ACCELERATION") & !leftOver[pos1 + i].equalsIgnoreCase("SENSORS")){
				count++;
				i++;
				pos3++;
			}
			groupIDS = new String[count];
			for( i = 1; i <= groupIDS.length; i++ ){
				groupIDS[i - 1] = leftOver[ pos1 + i];
				groups.add(Identifier.make(leftOver[pos1+i]));
			}
		}

		int pos = pos3 + 1, pos2 = pos;
		if(leftOver[4].equalsIgnoreCase("SENSORS")){
			 pos = 4; pos2 = pos;
		}else {
			 pos = pos3 + 1; pos2 = pos;
		}

		if(leftOver[pos].equalsIgnoreCase("SENSORS")) { // getting the name of all sensors
			int count = 0;
			int i = 1;
			while(!leftOver[pos + i].equalsIgnoreCase("ACCELERATION")){
				count++;
				i++;
				pos2++;
			}
			sensorIDs = new String[count];
			for( i = 1; i <= sensorIDs.length; i++ ){
				sensorIDs[i - 1] = leftOver[ pos + i];
				sensorID.add(Identifier.make(leftOver[pos+i]));
			}
		}
		int accelPos = 0;
		while(!leftOver[accelPos].equalsIgnoreCase("ACCELERATION") ){
			accelPos ++;
		}
		if(leftOver[accelPos ].equalsIgnoreCase("ACCELERATION")) {// gets information after sensors
			int w = accelPos;
			leadin = Double.parseDouble(leftOver[w + 2].trim()); // converting leading value to double
			leadout = Double.parseDouble(leftOver[w + 4].trim()); // converting leading value to double
			relax = Double.parseDouble(leftOver[w + 6].trim()); // gettin relax value
			vL = Integer.parseInt(leftOver[w + 9].trim()); // gettin velocity limit
			vMin = Integer.parseInt(leftOver[w +12].trim());
			vMax = Integer.parseInt(leftOver[w + 14].trim());
			initial = Integer.parseInt(leftOver[w + 16].trim());
			jerkLimit = Integer.parseInt(leftOver[w + 19].trim());
		}
/*
		System.out.println("Creating Actuartor with name: " + actID + ", type: " + type + ", Group size: " + groups.size()+ ", Sensors: " + sensorIDs[0] + "\n" + // Test print for values
				"Acceleration leading: " + leadin + ", out: " + leadout + ", RELAX: " + relax + ", Vel Limit: " + vL + "\n"+
				"val min: " + vMin + ", val max: " + vMax + ", Initial: " + initial +", jerkLimit: " + jerkLimit + "\n\n");


 */

		List<A_Sensor> sensorsL =  parserHelper.getSymbolTableSensor().get(sensorID, true);
		ActuatorPrototype newAct = new ActuatorPrototype(Identifier.make(actID), groups , leadin, leadout, relax, vL, initial, vMin, vMax, jerkLimit, sensorsL);
		parserHelper.getSymbolTableActuator().add(Identifier.make(actID), newAct);

	}// end of getInfor function

	public static void getMapperInfo(String[] leftOver, A_ParserHelper parserHelper) throws IOException{
		String mapperID = leftOver[2], interType = null;
		String fileLocation = null; Filespec file = null;
		double scaleValue = 0, norVal1 = 0, norVal2 = 0;
		
		if(leftOver[3].equalsIgnoreCase("EQUATION") && leftOver[4].equalsIgnoreCase("PASSTHROUGH")){
			// CREATE MAPPER OBJECT HERE
			//System.out.println("Creating mapper with name: " + mapperID + " type Passthrough" );
			EquationPassthrough passthr = new EquationPassthrough();
			MapperEquation map = new MapperEquation(passthr);
			parserHelper.getSymbolTableMapper().add(Identifier.make(mapperID), map);
		}
		else if(leftOver[3].equalsIgnoreCase("EQUATION") && leftOver[4].equalsIgnoreCase("SCALE")){
			scaleValue = Integer.parseInt(leftOver[5].trim());
			EquationScaled passthr = new EquationScaled(scaleValue);
			MapperEquation map = new MapperEquation(passthr);
			parserHelper.getSymbolTableMapper().add(Identifier.make(mapperID), map);
			// CREATE MAPPER OBJECT HERE
			//System.out.println("Creating mapper with name: " + mapperID + " with scale value of " + scaleValue );

		}
		else if(leftOver[3].equalsIgnoreCase("EQUATION") && leftOver[4].equalsIgnoreCase("NORMALIZE")){
			norVal1 = Double.parseDouble(leftOver[5].trim());
			norVal2 = Double.parseDouble(leftOver[6].trim());
			// CREATE MAPPER OBJECT HERE
			//System.out.println("Creating mapper with name: " + mapperID + " with normalization values of " + norVal1 + ", " + norVal2   );
			EquationNormalized passthr = new EquationNormalized(norVal1,norVal2);
			MapperEquation map = new MapperEquation(passthr);
			parserHelper.getSymbolTableMapper().add(Identifier.make(mapperID), map);
		}
		else if(leftOver[3].equalsIgnoreCase("INTERPOLATION") && (leftOver[4].equalsIgnoreCase("LINEAR") ||
				leftOver[4].equalsIgnoreCase("SPLINE"))	){
				interType = leftOver[4].trim();
				if(leftOver[5].equalsIgnoreCase("DEFINITION") ){
					fileLocation = leftOver[6].trim().substring(1, leftOver[6].length() - 1);
					 file = new Filespec(fileLocation);
				}
				MapLoader ml = new MapLoader(file);
				InterpolationMap im = ml.load();
				if(interType.equalsIgnoreCase("SPLINE")) {
					InterpolatorSpline Is = new InterpolatorSpline(im);
					MapperInterpolation mI = new MapperInterpolation(Is);
					parserHelper.getSymbolTableMapper().add(Identifier.make(mapperID), mI);
				}
				else if(interType.equalsIgnoreCase("LINEAR")) {
					InterpolatorLinear Is = new InterpolatorLinear(im);
					MapperInterpolation mI = new MapperInterpolation(Is);
					parserHelper.getSymbolTableMapper().add(Identifier.make(mapperID), mI);
				}
			//System.out.println("Creating mapper with name: " + mapperID + ", Interpolation: " + interType + "Definition: " + fileLocation );

		}





	}


}
