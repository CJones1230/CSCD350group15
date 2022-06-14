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
		
		if(leftOver[2].equalsIgnoreCase("PING"))
		{
			//SEND MESSAGE PING
			CommandLineInterface cli = currParser.getParserHelper().getCommandLineInterface();
			A_Message message = new MessagePing();
			cli.issueMessage(message);
		}
		else if(leftOver[(leftOver.length - 2)].equalsIgnoreCase("REQUEST"))
		{
			//SEND MESSAGE [ids] [groups] POSITION REQUEST value
			List<Identifier> ids = new ArrayList<Identifier>();
			List<Identifier> groups = new ArrayList<Identifier>();
			int i = 3;
			if(leftOver[(i - 1)].equalsIgnoreCase("ID"))
			{
				while(!(leftOver[i].equalsIgnoreCase("GROUPS")) && i < (leftOver.length - 3))
				{
					ids.add(Identifier.make(leftOver[i]));
					i++;
				}
			}
			if(leftOver[(i - 1)].equalsIgnoreCase("GROUPS") || leftOver[i].equalsIgnoreCase("GROUPS"))
			{
				if(leftOver[i].equalsIgnoreCase("GROUPS"))
				{
					i++;
				}
				while(i < (leftOver.length - 3))
				{
					groups.add(Identifier.make(leftOver[i]));
					i++;
				}
			}
			CommandLineInterface cli = currParser.getParserHelper().getCommandLineInterface();
			if(ids.size() > 0)
			{	
				A_Message message = new  MessageActuatorRequestPosition(ids, Double.parseDouble(leftOver[(leftOver.length - 1)]));
				cli.issueMessage(message);
			}
			if(groups.size() > 0)
			{
				A_Message message2 = new  MessageActuatorRequestPosition(groups, Double.parseDouble(leftOver[(leftOver.length - 1)]), 0);
			
				cli.issueMessage(message2);
			}
		}
		else if(leftOver[(leftOver.length - 1)].equalsIgnoreCase("REPORT"))
		{
			/*
			List<Identifier> ids = new ArrayList<Identifier>();
			//SEND MESSAGE [ids] [groups] POSITION REPORT
			for(int i = 3; i < leftOver.length - 3; i++)
			{
				ids.add(Identifier.make(leftOver[i]));
			}
			CommandLineInterface cli = currParser.getParserHelper().getCommandLineInterface();
			A_Message message = new  MessageActuatorReportPosition(ids);
			cli.issueMessage(message);
			*/
			List<Identifier> ids = new ArrayList<Identifier>();
			List<Identifier> groups = new ArrayList<Identifier>();
			int i = 3;
			if(leftOver[(i - 1)].equalsIgnoreCase("ID"))
			{
				while(!(leftOver[i].equalsIgnoreCase("GROUPS")) && i < (leftOver.length - 2))
				{
					ids.add(Identifier.make(leftOver[i]));
					i++;
				}
			}
			if(leftOver[(i - 1)].equalsIgnoreCase("GROUPS") || leftOver[i].equalsIgnoreCase("GROUPS"))
			{
				if(leftOver[i].equalsIgnoreCase("GROUPS"))
				{
					i++;
				}
				while(i < (leftOver.length - 2))
				{
					groups.add(Identifier.make(leftOver[i]));
					i++;
				}
			}
			CommandLineInterface cli = currParser.getParserHelper().getCommandLineInterface();
			if(ids.size() > 0)
			{
				A_Message message = new  MessageActuatorReportPosition(ids);
				cli.issueMessage(message);
			}
			if(groups.size() > 0)
			{
				A_Message message2 = new  MessageActuatorReportPosition(groups, 0);
			
				cli.issueMessage(message2);
			}
		}
		else//Error output
		{
			throw new RuntimeException("SEND MESSAGE NOT IN CORRECT FORMAT: sendFuntions");
		}
	}
}
