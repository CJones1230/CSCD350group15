package cs350s22.component.ui.parser;

public class ParseSet {

    public static void initialSet(String[] commandArray, A_ParserHelper parserHelper) {

       switch(commandArray[1]) {

           case "sensor": ParseSensor.setSensor(commandArray, parserHelper);
               break;

       }

    }// end method

}// end class