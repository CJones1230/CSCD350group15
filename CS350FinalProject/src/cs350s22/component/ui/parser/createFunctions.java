package cs350s22.component.ui.parser;

public class createFunctions {
	
	public static void initialCreate(String[] leftOver) {
		if(leftOver[1].equalsIgnoreCase("actuator")) {
			createActuator(leftOver);
		}
		else if(leftOver[1].equalsIgnoreCase("watchdog")){

		}
		else if(leftOver[1].equalsIgnoreCase("sensor")){

		}
		else if(leftOver[1].equalsIgnoreCase("reporter")){

		}
	}

	public static void createActuator (String[] leftOver){
		String type = null;
		String actID = null;
		double leadin, leadout, relax;
		int vL, vMin, vMax, initial, jerkLimit;
		if(leftOver[2].equalsIgnoreCase("LINEAR") || leftOver[2].equalsIgnoreCase("ROTARY")){
			type = leftOver[2]; // gets the type of actuator
			actID = leftOver[3]; // gets the name of the actuatoc
		}
		if(leftOver[4].equalsIgnoreCase("ACCELERATION")) {
			leadin =  Double.parseDouble(leftOver[6].trim()); // converting leading value to double
			leadout =  Double.parseDouble(leftOver[8].trim()); // converting leading value to double
			relax =  Double.parseDouble(leftOver[10].trim()); // gettin relax value
			vL =  Integer.parseInt(leftOver[13].trim()); // gettin velocity limit
			vMin = Integer.parseInt(leftOver[16].trim());
			vMax = Integer.parseInt(leftOver[18].trim());
			initial = Integer.parseInt(leftOver[20].trim());
			jerkLimit = Integer.parseInt(leftOver[23].trim());

		}



	}


}
