package cs350s22.component.ui.parser;

import cs350s22.component.sensor.A_Sensor;
import cs350s22.component.sensor.reporter.A_Reporter;
import cs350s22.component.sensor.watchdog.A_Watchdog;
import cs350s22.support.Identifier;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ParseSensor {
    public static void createSensor(String[] command, A_ParserHelper parserHelper) {

        A_Sensor sensor = null;
        Identifier sensorID = Identifier.make(command[3]);
        List<Identifier> groups = new ArrayList<Identifier>();
        List<A_Reporter> reporters = new ArrayList<A_Reporter>();
        List<A_Watchdog> watchdogs = new ArrayList<A_Watchdog>();

        int j;

        for (int i = 4; i < command.length - 4; i++) {
            switch (command[i]) {

                case "group":
                    j = i + 1;
                    while(command.length != j && !Objects.equals(command[j], "frequency")) {

                        groups.add(Identifier.make(command[j]));

                    }// end while loop
                    break;

                case "reporters":
                    j = i + 1;
                    while(command.length != j && !Objects.equals(command[j], "watchdogs")) {

                        parserHelper.getSymbolTableReporter();

                    }// end while loop
                    break;

                case "watchdogs":
                    break;

                case "mapper":
                    break;

            }// end switch

        }// end for loop

        parserHelper.getSymbolTableSensor().add(sensorID, sensor);  // store ID in symbol table

    }// end method

}// end class
