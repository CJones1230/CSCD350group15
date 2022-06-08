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
		String[] stringParts = command.toLowerCase().split(" "); // splits command on spaces, adjust as needed
		//printStrings(stringParts);
		if(stringParts[0].equalsIgnoreCase("create")) 
			ParseCreate.initialCreate(stringParts);
		/*
		else if(stringParts[0].equalsIgnoreCase("build"))
			buildFunctions.initialBuild(stringParts);
		else if(stringParts[0].equalsIgnoreCase("send"))
			sendFunctions.initialSend(stringParts);
		else if(stringParts[0].equalsIgnoreCase("@CLOCK"))
			atCommands.initialClock();
		else if(stringParts[0].equalsIgnoreCase("@EXIT"))
			atCommands.initialExit();
		else if(stringParts[0].equalsIgnoreCase("@RUN"))
			atCommands.initialRun();
		else if(stringParts[0].equalsIgnoreCase("@CONFIGURE"))
			atCommands.initialConfigure();

		 */
		else
			System.out.println("Error: Unvalid Command");
			
			
		
		//if() whatever the first token is
		
	}
	
	public static void printStrings(String[] command) {// prints out each token on a seperat line
		for(int i = 0; i < command.length; i++)
			System.out.println(command[i]);
	}

}
