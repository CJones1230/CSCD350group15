package cs350s22.component.ui.parser;

import cs350s22.component.sensor.watchdog.*;
import cs350s22.component.sensor.watchdog.mode.*;
import cs350s22.support.Identifier;

public class ParseWatchdog {
    public static void createWatchdog(String[] command, A_ParserHelper parserHelper) {

        A_Watchdog watchdog = null;
        A_WatchdogMode mode = null;
        Identifier watchdogID = Identifier.make(command[3]);
        double thresholdLow = 0;
        double thresholdHigh = 0;
        double threshold = 0;
        int complianceFailureThreshold = 0;
        boolean grace = false;

        for (int i = 4; i < command.length - 4; i++) {
            switch (command[i]) {

                case "mode":
                    switch(command[i + 1]) {

                        case "instantaneous": mode = new WatchdogModeInstantaneous();
                            break;

                        case "average": mode = new WatchdogModeAverage(Integer.valueOf(command[i + 2]));
                            break;

                        case "standard": mode = new WatchdogModeStandardDeviation(Integer.valueOf(command[i + 3]));
                            break;

                        default:
                            System.out.println("Please Enter a Valid Mode.");

                    }// end nested switch
                    break;

                case "threshold":
                    switch(command[i + 1]) {

                        case "low":
                            thresholdLow = Double.valueOf(command[i + 2]);
                            thresholdHigh = Double.valueOf(command[i + 4]);
                            break;

                        case "high":
                            thresholdHigh = Double.valueOf(command[i + 2]);
                            thresholdLow = Double.valueOf(command[i + 4]);
                            break;

                        default:
                            if (command[i + 1].matches("-?\\d+(\\.\\d+)?") == true) { // check if value is a double
                                threshold = Double.valueOf(command[i + 2]);
                            } else {
                                System.out.println("Please Enter a Valid Threshold.");
                            }
                    }// end nested switch
                    break;

                case "grace": complianceFailureThreshold = Integer.valueOf(command[i + 1]);
                     grace = true; // grace value is set
                    break;

            }// end switch

        }// end for loop

        switch(command[2]) {

            case "acceleration":
                if(grace) {
                    watchdog = new WatchdogAcceleration(thresholdLow, thresholdHigh, mode, complianceFailureThreshold);
                }
                else {
                    watchdog = new WatchdogAcceleration(thresholdLow,thresholdHigh, mode);
                }
                break;

            case "band":
                if(grace) {
                    watchdog = new WatchdogBand(thresholdLow, thresholdHigh, mode, complianceFailureThreshold);
                }
                else {
                    watchdog = new WatchdogBand(thresholdLow,thresholdHigh, mode);
                }
                break;

            case "notch":
                if(grace) {
                    watchdog = new WatchdogNotch(thresholdLow, thresholdHigh, mode, complianceFailureThreshold);
                }
                else {
                    watchdog = new WatchdogNotch(thresholdLow,thresholdHigh, mode);
                }
                break;

            case "low":
                if(grace) {
                    watchdog = new WatchdogLow(threshold, mode, complianceFailureThreshold);
                }
                else {
                    watchdog = new WatchdogLow(threshold, mode);
                }
                break;

            case "high":
                if(grace) {
                    watchdog = new WatchdogHigh(threshold, mode, complianceFailureThreshold);
                }
                else {
                    watchdog = new WatchdogHigh(threshold, mode);
                }
                break;

            default: System.out.println("Please Enter a Valid Type.");
        }// end switch

        parserHelper.getSymbolTableWatchdog().add(watchdogID, watchdog);  // store ID in symbol table

    }// end method

}// end class
