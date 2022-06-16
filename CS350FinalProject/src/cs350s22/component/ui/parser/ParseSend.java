// Ben Fristad
// Anthony Jones
// Collyn Jones

package cs350s22.component.ui.parser;

public class ParseSend {
	public static void initialSend(String[] commandArray, A_ParserHelper parserHelper) {

		switch (commandArray[1]) {

			case "message":
				ParseMessage.sendMessage(commandArray, parserHelper);
				break;

		}// end switch

	}// end method

}// end class
