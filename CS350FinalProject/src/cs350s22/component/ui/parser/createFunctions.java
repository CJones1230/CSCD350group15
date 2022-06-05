package cs350s22.component.ui.parser;

public class createFunctions {
	
	public static void initialCreate(String[] leftOver) {
		if(leftOver[1].equalsIgnoreCase("actuator")) {
			createActuator(leftOver);
		}
		else if(leftOver[1].equalsIgnoreCase("watchdog")){
			parseWatchdog(leftOver);
		}
		else if(leftOver[1].equalsIgnoreCase("sensor")){
			parseSensor(leftOver);
		}
		else if(leftOver[1].equalsIgnoreCase("reporter")){
			parseReporter(leftOver);
		}
	}

	public static void createActuator (String[] leftOver){
		if(leftOver[1].equalsIgnoreCase("LINEAR")){

		}
		if(leftOver[1].equalsIgnoreCase("ROTARY")){

		}

	}


}
