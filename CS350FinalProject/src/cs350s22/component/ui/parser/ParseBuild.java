package cs350s22.component.ui.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cs350s22.component.actuator.A_Actuator;
import cs350s22.component.controller.A_Controller;
import cs350s22.component.controller.A_ControllerForwarding;
import cs350s22.component.sensor.A_Sensor;
import cs350s22.network.Network;
import cs350s22.support.Identifier;

public class ParseBuild {
	public static void initialBuild(String[] commandArray, A_ParserHelper parserHelper) {

		switch (commandArray[1]) {

			case "network":
				ParseNetwork.buildNetwork(commandArray, parserHelper);
				break;

		}// end switch


		
	}
}
