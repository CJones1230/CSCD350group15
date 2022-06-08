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
	public static void initialSend(String[] leftOver, Parser currParser) {
		System.out.println(leftOver[1]);
		
		if(leftOver[2].equals("PING"))
		{
			//SEND MESSAGE PING
			CommandLineInterface cli = currParser.getParserHelper().getCommandLineInterface();
			A_Message message = new MessagePing();
			cli.issueMessage(message);
		}
		if(leftOver[(leftOver.length - 2)].equals("RESULT"))
		{
			//SEND MESSAGE [ids] [groups] POSITION REQUEST value
			List<Identifier> ids = new ArrayList<Identifier>();
			for(int i = 3; i < leftOver.length - 2; i++)
			{
				ids.add(Identifier.make(leftOver[i]));
			}
			CommandLineInterface cli = currParser.getParserHelper().getCommandLineInterface();
			A_Message message = new  MessageActuatorRequestPosition(ids, Double.parseDouble(leftOver[(leftOver.length - 1)]));
			cli.issueMessage(message);

		}
		if(leftOver[(leftOver.length - 1)].equals("REPORT"))
		{
			List<Identifier> ids = new ArrayList<Identifier>();
			//SEND MESSAGE [ids] [groups] POSITION REPORT
			for(int i = 3; i < leftOver.length - 3; i++)
			{
				ids.add(Identifier.make(leftOver[i]));
			}
			CommandLineInterface cli = currParser.getParserHelper().getCommandLineInterface();
			A_Message message = new  MessageActuatorReportPosition(ids);
			cli.issueMessage(message);
		}
		else//Error output
		{
			System.out.println("SEND MESSAGE NOT IN CORRECT FORMAT: sendFuntions");
		}
	}
}
