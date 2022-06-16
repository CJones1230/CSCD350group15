// Ben Fristad
// Anthony Jones
// Collyn Jones

package cs350s22.component.ui.parser;

import cs350s22.component.actuator.A_Actuator;
import cs350s22.component.controller.A_Controller;
import cs350s22.component.controller.A_ControllerForwarding;
import cs350s22.component.sensor.A_Sensor;
import cs350s22.network.Network;
import cs350s22.support.Identifier;

import java.util.ArrayList;
import java.util.List;

public class ParseNetwork {

    public static void buildNetwork(String[] leftOver, A_ParserHelper parserHelper) {

        List<Identifier> ids = new ArrayList<Identifier>();
        for (int i = 4; i < leftOver.length; i++) {
            ids.add(Identifier.make(leftOver[i]));
        }

        A_ControllerForwarding mc = parserHelper.getControllerMaster();
        SymbolTable<A_Actuator> acts = parserHelper.getSymbolTableActuator();
        SymbolTable<A_Controller> control = parserHelper.getSymbolTableController();
        SymbolTable<A_Sensor> sens = parserHelper.getSymbolTableSensor();
        for (int i = 0; i < ids.size(); i++) {
            if (acts.contains(ids.get(i))) {
                mc.addComponent(acts.get(ids.get(i)));
            }
            if (control.contains(ids.get(i))) {
                mc.addComponent(control.get(ids.get(i)));
            }
            if (sens.contains(ids.get(i))) {
                mc.addComponent(sens.get(ids.get(i)));
            }
        }
        Network net = parserHelper.getNetwork();
        net.writeOutput();

    }// end method

}// end class
