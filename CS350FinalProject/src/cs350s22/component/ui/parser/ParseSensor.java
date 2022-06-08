package cs350s22.component.ui.parser;

import cs350s22.component.sensor.A_Sensor;
import cs350s22.support.Identifier;

public class ParseSensor {
    public static void createSensor(String[] command, A_ParserHelper parserHelper) {

        A_Sensor sensor = null;
        Identifier sensorID = Identifier.make(command[3]);

        for (int i = 4; i < command.length - 4; i++) {
            switch (command[i]) {

                case "group":
                    break;

                case "reporters":
                    break;

                case "mappers":
                    break;

                case "watchdogs":
                    break;

            }// end switch

        }// end for loop

        parserHelper.getSymbolTableSensor().add(sensorID, sensor);  // store ID in symbol table

    }// end method

}// end class
