// Ben Fristad
// Anthony Jones
// Collyn Jones

package cs350s22.component.ui.parser;

public class ParseBuild {
	public static void initialBuild(String[] commandArray, A_ParserHelper parserHelper) {

		switch (commandArray[1]) {

			case "network":
				ParseNetwork.buildNetwork(commandArray, parserHelper);
				break;

		}// end switch


		
	}
}
