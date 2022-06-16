// Ben Fristad
// Anthony Jones
// Collyn Jones

package cs350s22.component.ui.parser;

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

import java.io.IOException;

public class ParseMapper {

    public static void createMapper(String[] leftOver, A_ParserHelper parserHelper) throws IOException {

        String mapperID = leftOver[2], interType = null;
        String fileLocation = null; Filespec file = null;
        double scaleValue = 0, norVal1 = 0, norVal2 = 0;

        if(leftOver[3].equalsIgnoreCase("EQUATION") && leftOver[4].equalsIgnoreCase("PASSTHROUGH")){
            // CREATE MAPPER OBJECT HERE
            //System.out.println("Creating mapper with name: " + mapperID + " type Passthrough" );
            EquationPassthrough passthr = new EquationPassthrough();
            MapperEquation map = new MapperEquation(passthr);
            parserHelper.getSymbolTableMapper().add(Identifier.make(mapperID), map);
        }
        else if(leftOver[3].equalsIgnoreCase("EQUATION") && leftOver[4].equalsIgnoreCase("SCALE")){
            scaleValue = Integer.parseInt(leftOver[5].trim());
            EquationScaled passthr = new EquationScaled(scaleValue);
            MapperEquation map = new MapperEquation(passthr);
            parserHelper.getSymbolTableMapper().add(Identifier.make(mapperID), map);
            // CREATE MAPPER OBJECT HERE
            //System.out.println("Creating mapper with name: " + mapperID + " with scale value of " + scaleValue );

        }
        else if(leftOver[3].equalsIgnoreCase("EQUATION") && leftOver[4].equalsIgnoreCase("NORMALIZE")){
            norVal1 = Double.parseDouble(leftOver[5].trim());
            norVal2 = Double.parseDouble(leftOver[6].trim());
            // CREATE MAPPER OBJECT HERE
            //System.out.println("Creating mapper with name: " + mapperID + " with normalization values of " + norVal1 + ", " + norVal2   );
            EquationNormalized passthr = new EquationNormalized(norVal1,norVal2);
            MapperEquation map = new MapperEquation(passthr);
            parserHelper.getSymbolTableMapper().add(Identifier.make(mapperID), map);
        }
        else if(leftOver[3].equalsIgnoreCase("INTERPOLATION") && (leftOver[4].equalsIgnoreCase("LINEAR") ||
                leftOver[4].equalsIgnoreCase("SPLINE"))	){
            interType = leftOver[4].trim();
            if(leftOver[5].equalsIgnoreCase("DEFINITION") ){
                fileLocation = leftOver[6].trim().substring(1, leftOver[6].length() - 1);
                file = new Filespec(fileLocation);
            }
            MapLoader ml = new MapLoader(file);
            InterpolationMap im = ml.load();
            if(interType.equalsIgnoreCase("SPLINE")) {
                InterpolatorSpline Is = new InterpolatorSpline(im);
                MapperInterpolation mI = new MapperInterpolation(Is);
                parserHelper.getSymbolTableMapper().add(Identifier.make(mapperID), mI);
            }
            else if(interType.equalsIgnoreCase("LINEAR")) {
                InterpolatorLinear Is = new InterpolatorLinear(im);
                MapperInterpolation mI = new MapperInterpolation(Is);
                parserHelper.getSymbolTableMapper().add(Identifier.make(mapperID), mI);
            }
            //System.out.println("Creating mapper with name: " + mapperID + ", Interpolation: " + interType + "Definition: " + fileLocation );

        }

    }// end method

}// end class
