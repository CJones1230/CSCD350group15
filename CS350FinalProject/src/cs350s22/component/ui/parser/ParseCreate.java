package cs350s22.component.ui.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cs350s22.component.sensor.A_Sensor;
import cs350s22.component.sensor.mapper.MapperEquation;
import cs350s22.component.sensor.mapper.MapperInterpolation;
import cs350s22.component.sensor.mapper.function.equation.EquationNormalized;
import cs350s22.component.sensor.mapper.function.equation.EquationPassthrough;
import cs350s22.component.sensor.mapper.function.equation.EquationScaled;
import cs350s22.component.sensor.mapper.function.interpolator.InterpolationMap;
import cs350s22.component.sensor.mapper.function.interpolator.InterpolatorLinear;
import cs350s22.component.sensor.mapper.function.interpolator.InterpolatorSpline;
import cs350s22.component.sensor.mapper.function.interpolator.loader.MapLoader;
import cs350s22.support.Filespec;
import cs350s22.support.Identifier;
import cs350s22.test.ActuatorPrototype;

public class ParseCreate {

	public static void initialCreate(String[] commandArray, A_ParserHelper parserHelper) throws IOException {

		switch (commandArray[1]) {

			case "actuator":
				ParseActuator.createActuator(commandArray, parserHelper);
				break;

			case "mapper":
				ParseMapper.createMapper(commandArray, parserHelper);
				break;

			case "watchdog":
				ParseWatchdog.createWatchdog(commandArray, parserHelper);
				break;

			case "sensor":
				ParseSensor.createSensor(commandArray, parserHelper);
				break;

			case "reporter":
				ParseReporter.createReporter(commandArray, parserHelper);
				break;

		}// end switch

	}// end method

}// end class
