package cs350s22.component.ui.parser;

public class ParseWatchdog {
    public static void createWatchdog(String[] command) {

        String type;
        String mode;

        for (int i = 3; i < command.length - 3; i++) {
            switch (command[i]) {

                case "mode":
                    mode = command[i] + 1;// FIX

                case "threshold":
                    break;

                case "grace":
                    break;


            }// end switch

        }// end for loop

    }// end method

}// end class
