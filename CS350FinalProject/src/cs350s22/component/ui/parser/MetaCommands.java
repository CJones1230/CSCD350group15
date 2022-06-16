// Ben Fristad
// Anthony Jones
// Collyn Jones

package cs350s22.component.ui.parser;

import cs350s22.component.logger.LoggerMessage;
import cs350s22.component.logger.LoggerMessageSequencing;
import cs350s22.support.Clock;
import cs350s22.support.Filespec;

import java.io.IOException;
import java.util.Date;

public class MetaCommands {
	public static void initialClock(String[] leftOver) {
		int count = 1;
		if (leftOver.length == 1){
			Date now = new Date();
			System.out.println(now);
		}
		else if(leftOver[1].trim().equalsIgnoreCase("PAUSE")){ // E1
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
		else if(leftOver[1].trim().equalsIgnoreCase("WAIT") && leftOver[2].trim().equalsIgnoreCase("FOR")) {
			double waitTime = Double.valueOf(leftOver[3]);
			Clock.getInstance().waitFor(waitTime);
		}
		else if(leftOver[1].trim().equalsIgnoreCase("WAIT") && leftOver[2].trim().equalsIgnoreCase("UNTIL")) {
			double waitTime = Double.valueOf(leftOver[3]);
			Clock.getInstance().waitUntil(waitTime);
		}
		
	}
	public static void initialExit(Parser currParser) {
		currParser.getParserHelper().exit();
	}
	public static void initialRun(String[] leftOver, Parser currParser) throws ParseException, IOException {
		currParser.getParserHelper().run(leftOver[1]);
	}
	public static void initialConfigure(String[] leftOver, Parser currParser) throws IOException {
		System.getProperty("java.io.dir");

		LoggerMessage.initialize(new Filespec(leftOver[2]));
		
		LoggerMessageSequencing.initialize((new Filespec(leftOver[5])), (new Filespec(leftOver[7])));
		
	}
}
