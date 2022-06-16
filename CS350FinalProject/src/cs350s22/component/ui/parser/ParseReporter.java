// Ben Fristad
// Anthony Jones
// Collyn Jones

package cs350s22.component.ui.parser;

import cs350s22.component.sensor.reporter.A_Reporter;
import cs350s22.component.sensor.reporter.ReporterChange;
import cs350s22.component.sensor.reporter.ReporterFrequency;
import cs350s22.support.Identifier;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ParseReporter {
    public static void createReporter(String[] command, A_ParserHelper parserHelper){

        A_Reporter reporter = null;
        List<Identifier> ids = new ArrayList<Identifier>();
        List<Identifier> groups = new ArrayList<Identifier>();
        Identifier reporterID = Identifier.make(command[3]);
        boolean isChange = false;
        boolean isFrequency = false;
        int reportingFrequency = 0;
        int deltaThreshold = 0;

        for (int i = 4; i < command.length; i++) {
            switch (command[i]) {

                case "delta":
                    isChange = true; // set change flag
                    deltaThreshold = Integer.valueOf(command[i + 1]);
                    break;

                case "frequency":
                    isFrequency = true; // set frequency flag
                    reportingFrequency = Integer.valueOf(command[i + 1]);
                    break;

                case "notify":

                    while(!Objects.equals(command[i + 1], "frequency") && !Objects.equals(command[i + 1], "delta")) {
                        int j = i;
                        switch(command[j + 1]) {

                            case "ids":
                                while (!Objects.equals(command[j + 2], "groups") && !Objects.equals(command[j + 2], "frequency") && !Objects.equals(command[j + 2], "delta")) {

                                    ids.add(Identifier.make(command[j + 2]));
                                    j++;
                                }// end while loop
                                break;

                            case "groups":
                                while (!Objects.equals(command[j + 2], "ids") && !Objects.equals(command[j + 2], "frequency") && !Objects.equals(command[j + 2], "delta")) {

                                    groups.add(Identifier.make(command[j + 2]));
                                    j++;
                                }// end while loop
                                break;

                        }// end switch
                        i++;
                    }// end for loop
                    break;

            }// end switch

        }// end for loop

        if(isChange && groups.isEmpty()) {
            reporter = new ReporterChange(ids, deltaThreshold);
        }
        else if(isChange) {
            reporter = new ReporterChange(ids, groups, deltaThreshold);
        }
        else if(isFrequency && groups.isEmpty()) {
            reporter = new ReporterFrequency(ids, reportingFrequency);
        }
        else if(isFrequency) {
            reporter = new ReporterFrequency(ids, groups, reportingFrequency);
        }
        else {
            throw new RuntimeException("Please Enter Valid Type.");
        }

        parserHelper.getSymbolTableReporter().add(reporterID, reporter);  // store ID in symbol table

    }// end method

}// end class
