package cs350s22.component.ui.parser;

import java.io.IOException;

public class Parser implements ParserConstants { // implement other classes as needed
	private String command;
	protected A_ParserHelper parserHelper;
	
	
	public Parser(A_ParserHelper parserHelper, String commandText){
		this.parserHelper = parserHelper;
		this.command = commandText;
		
	}
	public void parse() throws IOException{
		System.out.println(command);
		String[] commandArray = command.trim().toLowerCase().split(" "); // splits command on spaces, adjust as needed

		switch(commandArray[0]) {

			case "create": ParseCreate.initialCreate(commandArray, parserHelper);
				break;

			case "build": ParseBuild.initialBuild(commandArray, this);
				break;

			case "send": ParseSend.initialSend(commandArray, this);
				break;

			/*
			case "@clock": MetaCommands.initialClock();
				break;
			 */
			case "@exit": MetaCommands.initialExit();
				break;

			case "@run": MetaCommands.initialRun();
				break;

			case "@configure": MetaCommands.initialConfigure();
				break;

			default: throw new RuntimeException("Error: Invalid Command");

		}// end switch
		
	}// end method
	
	public static void printStrings(String[] command) {// prints out each token on a seperate line
		for(int i = 0; i < command.length; i++)
			System.out.println(command[i]);
	}
	public A_ParserHelper getParserHelper()
	{
		return this.parserHelper;
	}
}
