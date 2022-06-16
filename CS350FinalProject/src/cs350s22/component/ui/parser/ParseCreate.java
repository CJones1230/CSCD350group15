package cs350s22.component.ui.parser;

import java.io.IOException;

public class ParseCreate {

	public static void initialCreate(String[] commandArray, A_ParserHelper parserHelper) throws IOException {

		switch (commandArray[1]) {

			case "actuator":
				ParseActuator.createActuator(commandArray, parserHelper);
				break;

			case "mapper":
				ParseMapper.createMapper(commandArray, parserHelper);
				break;

			case "watchdog":
				ParseWatchdog.createWatchdog(commandArray, parserHelper);
				break;

			case "sensor":
				ParseSensor.createSensor(commandArray, parserHelper);
				break;

			case "reporter":
				ParseReporter.createReporter(commandArray, parserHelper);
				break;

		}// end switch

	}// end method

}// end class
