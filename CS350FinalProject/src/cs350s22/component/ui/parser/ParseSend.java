package cs350s22.component.ui.parser;

import java.util.ArrayList;
import java.util.List;

import cs350s22.component.ui.CommandLineInterface;
import cs350s22.message.A_Message;
import cs350s22.message.actuator.MessageActuatorReportPosition;
import cs350s22.message.actuator.MessageActuatorRequestPosition;
import cs350s22.message.ping.MessagePing;
import cs350s22.support.Identifier;

public class ParseSend {
	public static void initialSend(String[] commandArray, A_ParserHelper parserHelper) {

		switch (commandArray[1]) {

			case "message":
				ParseMessage.sendMessage(commandArray, parserHelper);
				break;

		}// end switch

	}// end method

}// end class
