package cs350s22.component.ui.parser;

import cs350s22.component.sensor.A_Sensor;
import cs350s22.support.Identifier;
import cs350s22.test.ActuatorPrototype;

import java.util.ArrayList;
import java.util.List;

public class ParseActuator {

    public static void createActuator(String[] leftOver, A_ParserHelper parserHelper) {

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

    }// end method

}// end class
