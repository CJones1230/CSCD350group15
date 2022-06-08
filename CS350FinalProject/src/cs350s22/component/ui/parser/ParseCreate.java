package cs350s22.component.ui.parser;

public class ParseCreate {
	
	public static void initialCreate(String[] leftOver) {
		if(leftOver[1].equalsIgnoreCase("actuator")) {
			getActuatorInfo(leftOver);
		}
		else if(leftOver[1].equalsIgnoreCase("MAPPER")){
			getMapperInfo(leftOver);
		}
		else if(leftOver[1].equalsIgnoreCase("watchdog")){
			ParseWatchdog.createWatchdog(leftOver);
		}
		else if(leftOver[1].equalsIgnoreCase("sensor")){
			ParseSensor.createSensor(leftOver);
		}
		else if(leftOver[1].equalsIgnoreCase("reporter")){
			ParseReporter.createReporter(leftOver);
		}
	}

	public static void getActuatorInfo (String[] leftOver){
		String type = null;
		String actID = null;

		double leadin = 0.0, leadout = 0.0, relax = 0.0;
		int vL = 0, vMin= 0, vMax= 0, initial= 0, jerkLimit= 0;
		String[] sensorIDs = new String[1];
		if(leftOver[2].equalsIgnoreCase("LINEAR") || leftOver[2].equalsIgnoreCase("ROTARY")){
			type = leftOver[2]; // gets the type of actuator
			actID = leftOver[3]; // gets the name of the actuatoc
		}
		if(leftOver[4].equalsIgnoreCase("ACCELERATION")) {
			leadin =  Double.parseDouble(leftOver[6].trim()); // converting leading value to double
			leadout =  Double.parseDouble(leftOver[8].trim()); // converting leading value to double
			relax =  Double.parseDouble(leftOver[10].trim()); // gettin relax value
			vL =  Integer.parseInt(leftOver[13].trim()); // gettin velocity limit
			vMin = Integer.parseInt(leftOver[16].trim());
			vMax = Integer.parseInt(leftOver[18].trim());
			initial = Integer.parseInt(leftOver[20].trim());
			jerkLimit = Integer.parseInt(leftOver[23].trim());

		}
		int pos = 4, pos2 = pos;
		if(leftOver[4].equalsIgnoreCase("SENSORS")) { // getting the name of all sensors
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
			}
		}
		if(leftOver[pos2 + 1 ].equalsIgnoreCase("ACCELERATION")) {// gets information after sensors
			int w = pos2+1;
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
		System.out.println("Creating Actuartor with name: " + actID + ", type: " + type + ", Sensors: " + sensorIDs[3] + "\n" + // Test print for values
				"Acceleration leading: " + leadin + ", out: " + leadout + ", RELAX: " + relax + ", Vel Limit: " + vL + "\n"+
				"val min: " + vMin + ", val max: " + vMax + ", Initial: " + initial +", jerkLimit: " + jerkLimit);

		 */


	}// end of getInfor function

	public static void getMapperInfo(String[] leftOver){
		String mapperID = leftOver[2], fileLocation = null, interType = null;
		int scaleValue = 0, norVal1 = 0, norVal2 = 0;
		if(leftOver[3].equalsIgnoreCase("EQUATION") && leftOver[4].equalsIgnoreCase("PASSTHROUGH")){
			// CREATE MAPPER OBJECT HERE
			//System.out.println("Creating mapper with name: " + mapperID + " type Passthrough" );
		}
		else if(leftOver[3].equalsIgnoreCase("EQUATION") && leftOver[4].equalsIgnoreCase("SCALE")){
			scaleValue = Integer.parseInt(leftOver[5].trim());
			// CREATE MAPPER OBJECT HERE
			//System.out.println("Creating mapper with name: " + mapperID + " with scale value of " + scaleValue );

		}
		else if(leftOver[3].equalsIgnoreCase("EQUATION") && leftOver[4].equalsIgnoreCase("NORMALIZE")){
			norVal1 = Integer.parseInt(leftOver[5].trim());
			norVal2 = Integer.parseInt(leftOver[6].trim());
			// CREATE MAPPER OBJECT HERE
			//System.out.println("Creating mapper with name: " + mapperID + " with normalization values of " + norVal1 + ", " + norVal2   );

		}
		else if(leftOver[3].equalsIgnoreCase("INTERPOLATION") && (leftOver[4].equalsIgnoreCase("LINEAR") ||
				leftOver[4].equalsIgnoreCase("SPLINE"))	){
				interType = leftOver[4].trim();
				if(leftOver[5].equalsIgnoreCase("DEFINITION") ){
					fileLocation = leftOver[6].trim().substring(1, leftOver[6].length() - 1);
				}

			//System.out.println("Creating mapper with name: " + mapperID + ", Interpolation: " + interType + "Definition: " + fileLocation );

		}





	}


}
