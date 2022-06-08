package cs350s22.component.ui.parser;

import cs350s22.component.sensor.reporter.A_Reporter;
import cs350s22.component.sensor.reporter.ReporterChange;
import cs350s22.component.sensor.reporter.ReporterFrequency;
import cs350s22.support.Identifier;
import java.util.List;

public class ParseReporter {
    public static void createReporter(String[] command, A_ParserHelper parserHelper){

        A_Reporter reporter = null;
        List<Identifier> ids = null;
        List<Identifier> groups = null;
        Identifier reporterID = Identifier.make(command[3]);
        boolean isChange = false;
        boolean isFrequency = false;
        int reportingFrequency = 0;
        int deltaThreshold = 0;

        for (int i = 4; i < command.length - 4; i++) {
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
                    int j = i + 2;
                    if (command[i + 1].equals("ids")) {

                        while(command[j] != "groups" || command[j] != "frequency" || command[j] != "delta") {

                            Identifier id = null;
                            id.make(command[j]);


                        }// end while loop

                    }
                    else if(command[i + 1].equals("groups")) {
                        while(command[j] != "ids" || command[j] != "frequency" || command[j] != "delta") {

                            Identifier id = null;
                            id.make(command[j]);


                        }// end while loop
                    }
                    else {
                        System.out.println("Please Enter Valid Command.");
                    }
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
            System.out.println("Please Enter Valid Type.");
        }

        parserHelper.getSymbolTableReporter().add(reporterID, reporter);  // store ID in symbol table

    }// end method

}// end class
