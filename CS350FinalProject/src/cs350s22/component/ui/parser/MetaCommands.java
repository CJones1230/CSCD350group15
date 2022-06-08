package cs350s22.component.ui.parser;

import cs350s22.support.Clock;

public class MetaCommands {
	public static void initialClock(String[] leftOver) {
		int count = 1;
		if(leftOver[1].trim().equalsIgnoreCase("PAUSE")){ // E1
			Clock.getInstance().isActive(false);
		}
		else if(leftOver[1].trim().equalsIgnoreCase("RESUME")){ // E1
			Clock.getInstance().isActive(true);
		}
		else if(leftOver[1].trim().equalsIgnoreCase("ONESTEP") & Clock.getInstance().isActive() == false){
			if(leftOver.length <= 2){
				Clock.getInstance().onestep(1);
			}
			else{
				count = Integer.parseInt(leftOver[2].trim());
				Clock.getInstance().onestep(count);
			}
		}// E2
		else if(leftOver[1].trim().equalsIgnoreCase("SET") & leftOver[2].trim().equalsIgnoreCase("RATE")){
			count = Integer.parseInt(leftOver[3].trim());
			Clock.getInstance().setRate(count);
		}

		
	}
	public static void initialExit( ) {
		System.exit(0);
	}
	public static void initialRun() {
		
	}
	public static void initialConfigure() {

	}
}
