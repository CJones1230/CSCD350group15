package cs350s22.component.ui.parser;

import cs350s22.component.sensor.A_Sensor;
import cs350s22.component.sensor.mapper.A_Mapper;
import cs350s22.component.sensor.reporter.A_Reporter;
import cs350s22.component.sensor.watchdog.A_Watchdog;
import cs350s22.support.Identifier;
import cs350s22.test.MySensor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ParseSensor {
    public static void createSensor(String[] command, A_ParserHelper parserHelper) {

        MySensor sensor = null;
        Identifier sensorID = Identifier.make(command[3]);
        List<Identifier> groups = new ArrayList<Identifier>();
        List<A_Reporter> reporters = new ArrayList<A_Reporter>();
        List<A_Watchdog> watchdogs = new ArrayList<A_Watchdog>();
        A_Mapper mapper = null;

        int j;

        for (int i = 4; i < command.length; i++) {
            switch (command[i]) {

                case "group":
                    j = i + 1;
                    while(!Objects.equals(command[j], "reporters") && !Objects.equals(command[j], "watchdogs") && !Objects.equals(command[j], "mapper")) {

                        groups.add(Identifier.make(command[j]));
                        j++;

                    }// end while loop
                    break;

                case "reporters":
                    j = i + 1;
                    while(command.length != j && !Objects.equals(command[j], "watchdogs") && !Objects.equals(command[j], "mapper")) {

                        reporters.add(parserHelper.getSymbolTableReporter().get(Identifier.make(command[j])));
                        j++;

                    }// end while loop
                    break;

                case "watchdogs":
                    j = i + 1;
                    while(command.length != j && !Objects.equals(command[j], "mapper")) {

                        watchdogs.add(parserHelper.getSymbolTableWatchdog().get(Identifier.make(command[j])));
                        j++;

                    }// end while loop
                    break;

                case "mapper":
                    mapper = parserHelper.getSymbolTableMapper().get(Identifier.make(command[i + 1]));
                    break;

            }// end switch

        }// end for loop

        if(groups.isEmpty() && reporters.isEmpty() && watchdogs.isEmpty() && mapper == null) {
            sensor = new MySensor(sensorID);
        }
        else if(mapper == null) {
            sensor = new MySensor(sensorID, groups, reporters, watchdogs);
        }
        else {
            sensor = new MySensor(sensorID, groups, reporters, watchdogs, mapper);
        }

        parserHelper.getSymbolTableSensor().add(sensorID, sensor);  // store ID in symbol table

    }// end method

    public static void setSensor(String[] command, A_ParserHelper parserHelper) {

        A_Sensor sensor = parserHelper.getSymbolTableSensor().get(Identifier.make(command[2])); // retrieve the specified sensor from the symbol table

        if (Objects.equals(command[3], "value")) {

            double sensorValue = Double.valueOf(command[4]);
            sensor.setValue(sensorValue);
        } else {
            throw new IllegalArgumentException("Please Enter a Value");
        }

    }// end method

    public static void getSensor(String[] command, A_ParserHelper parserHelper) {

        A_Sensor sensor = parserHelper.getSymbolTableSensor().get(Identifier.make(command[2])); // retrieve the specified sensor from the symbol table

        if (Objects.equals(command[3], "value")) {

            System.out.println("Sensor value is " + sensor.getValue());
        } else {
            throw new IllegalArgumentException("Please Enter a valid command");
        }

    }// end method

}// end class
