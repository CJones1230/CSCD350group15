package cs350s22.component.ui.parser;

import java.util.ArrayList;
import java.util.List;

import cs350s22.component.actuator.A_Actuator;
import cs350s22.component.controller.A_Controller;
import cs350s22.component.controller.A_ControllerForwarding;
import cs350s22.component.sensor.A_Sensor;
import cs350s22.network.Network;
import cs350s22.support.Identifier;

public class ParseBuild {
	public static void initialBuild(String[] leftOver, Parser currParser) {
		System.out.println(leftOver[1]);
		List<Identifier> ids = new ArrayList<Identifier>();
		for(int i = 4; i < leftOver.length; i++)
		{
			ids.add(Identifier.make(leftOver[i]));
		}
		
		
		A_ControllerForwarding mc = currParser.getParserHelper().getControllerMaster();
		SymbolTable<A_Actuator> acts = currParser.getParserHelper().getSymbolTableActuator();
		SymbolTable<A_Controller> control = currParser.getParserHelper().getSymbolTableController();
		SymbolTable<A_Sensor> sens = currParser.getParserHelper().getSymbolTableSensor();
		for(int i = 0; i < ids.size(); i++)
		{
			if(acts.contains(ids.get(i)))
			{
				mc.addComponent(acts.get(ids.get(i)));
			}
			if(control.contains(ids.get(i)))
			{
				mc.addComponent(control.get(ids.get(i)));
			}
			if(sens.contains(ids.get(i)))
			{
				mc.addComponent(sens.get(ids.get(i)));
			}
		}
		Network net = currParser.getParserHelper().getNetwork();
		net.writeOutput();
		
	}
}
