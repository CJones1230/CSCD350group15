package cs350s22.component.ui.parser;

import java.util.ArrayList;
import java.util.List;

import cs350s22.support.Identifier;

public class ParseBuild {
	public static void initialBuild(String[] leftOver, Parser currParser) {
		System.out.println(leftOver[1]);
		List<Identifier> ids = new ArrayList<Identifier>();
		for(int i = 3; i < leftOver.length; i++)
		{
			ids.add(Identifier.make(leftOver[i]));
		}
		
	}
}
