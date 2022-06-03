package cs350s22.component.ui.parser;

import java.io.IOException;

public class Parser implements ParserConstants { // impliments other classes
	private String command;
	protected ParserHelper praserHelper;
	
	
	public Parser(A_ParserHelper parserHelper, String commandText){
		this.praserHelper = praserHelper;
		this.command = commandText;
		
	}
	public void parse() throws IOException{
		System.out.println(command);
		String[] stringParts = command.split(" ");
		for(int i = 0; i < stringParts.length; i++)
			System.out.println(stringParts[i]);
		//if() whatever the first token is
	}

}
