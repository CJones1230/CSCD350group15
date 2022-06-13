package cs350s22.component.ui.parser;

import java.io.IOException;

import cs350s22.component.logger.LoggerMessage;
import cs350s22.component.logger.LoggerMessageSequencing;
import cs350s22.support.Clock;
import cs350s22.support.Filespec;
import java.time.LocalDateTime;

public class MetaCommands {
	public static void initialClock(String[] leftOver) {
		int count = 1;
		if (leftOver.length == 1){
			LocalDateTime now = LocalDateTime.now();
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

		
	}
	public static void initialExit(Parser currParser) {
		currParser.getParserHelper().exit();
	}
	public static void initialRun(String[] leftOver, Parser currParser) throws ParseException, IOException {
		currParser.getParserHelper().run(leftOver[1]);
	}
	public static void initialConfigure(String[] leftOver, Parser currParser) throws IOException {
		LoggerMessage logger = LoggerMessage.getInstance();//could be wrong, just what I got from the javadoc
		logger.initialize(new Filespec(leftOver[2]));
		LoggerMessageSequencing logger2 = LoggerMessageSequencing.getInstance();
		logger2.initialize((new Filespec(leftOver[5])), (new Filespec(leftOver[7])));
		
	}
}
