// Ben Fristad
// Anthony Jones
// Collyn Jones

package cs350s22.component.ui.parser;

public class ParseGet {

    public static void initialGet(String[] commandArray, A_ParserHelper parserHelper) {

        switch(commandArray[1]) {

            case "sensor": ParseSensor.getSensor(commandArray, parserHelper);
                break;

        }// end switch

    }// end method

}// end class
