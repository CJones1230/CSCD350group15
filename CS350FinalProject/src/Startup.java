import cs350s22.component.ui.parser.A_ParserHelper;
import cs350s22.component.ui.parser.Parser;
import cs350s22.component.ui.parser.ParserHelper;

//=================================================================================================================================================================================
public class Startup
{
   private final A_ParserHelper _parserHelper = new ParserHelper();
   
   // -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
   public Startup()
   {
      System.out.println("Welcome to your Startup class");
   }

   // -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
   public static void main(final String[] arguments) throws Exception
   {
      Startup startup = new Startup();
      
      // this command must come first. The filenames do not matter here
      //startup.parse("@CONFIGURE LOG \"a.txt\" DOT SEQUENCE \"b.txt\" NETWORK \"c.txt\" XML \"d.txt\"");

      // run your tests like this

      // Actuator Commands
      //startup.parse("CREATE ACTUATOR LINEAR myActuator0 ACCELERATION LEADIN 0.1 LEADOUT -0.2 RELAX 0.3 VELOCITY LIMIT 5 VALUE MIN 1 MAX 10 INITIAL 2 JERK LIMIT 3");
      //startup.parse("CREATE ACTUATOR ROTARY myActuator8 SENSORS mySensor3 ACCELERATION LEADIN 0.1 LEADOUT -0.2 RELAX 0.3 VELOCITY LIMIT 5 VALUE MIN 1 MAX 10 INITIAL 2 JERK LIMIT 3");

      // Mapper Commands
      //startup.parse("CREATE MAPPER myMapper EQUATION PASSTHROUGH");

      //startup.parse("CREATE MAPPER myMapper EQUATION SCALE 10");

      //startup.parse("CREATE MAPPER myMapper EQUATION NORMALIZE 10 20");

      //startup.parse("CREATE MAPPER myMapper INTERPOLATION LINEAR DEFINITION mapfile.map");
      //startup.parse("CREATE MAPPER myMapper INTERPOLATION SPLINE DEFINITION C:/temp/definition.map");

      // Message Commands
      //startup.parse("SEND MESSAGE PING");

      //startup.parse("SEND MESSAGE ID myActuator1 POSITION REQUEST 10");
      //startup.parse("SEND MESSAGE GROUPS myActuators1 myActuators2 POSITION REQUEST 20");
      //startup.parse("SEND MESSAGE ID myActuator1 GROUPS myActuators1 myActuators2 POSITION REQUEST 30");

      //startup.parse("SEND MESSAGE ID myActuator1 POSITION REPORT");
      //startup.parse("SEND MESSAGE GROUPS myActuators1 myActuators2 POSITION REPORT");
      //startup.parse("SEND MESSAGE ID myActuator1 GROUPS myActuators1 myActuators2 POSITION REPORT");

      // Network Commands
      //startup.parse("BUILD NETWORK WITH COMPONENT myController");
      //startup.parse("BUILD NETWORK WITH COMPONENTS myController myActuator");

      // Reporter Commands
      startup.parse("CREATE REPORTER CHANGE myReporter1 NOTIFY IDS myActuator1 myActuator2 DELTA 3");

      //startup.parse("CREATE REPORTER FREQUENCY myReporter6 NOTIFY IDS myActuator1 myActuator2 GROUPS myGroup3 FREQUENCY 4");

      // Watchdog Commands
      startup.parse("CREATE WATCHDOG BAND myWatchdog1 MODE INSTANTANEOUS THRESHOLD LOW 1 HIGH 3");
      startup.parse("CREATE WATCHDOG NOTCH myWatchdog2 MODE AVERAGE 10 THRESHOLD LOW 1 HIGH 3 GRACE 4");

      //startup.parse("CREATE WATCHDOG LOW myWatchdog3 MODE STANDARD DEVIATION THRESHOLD 3 GRACE 4");
      //startup.parse("CREATE WATCHDOG HIGH myWatchdog4 MODE STANDARD DEVIATION 10 THRESHOLD 3 GRACE 4");

      // Sensor Commands
      startup.parse("CREATE SENSOR POSITION mySensor8 GROUP myGroup1 REPORTERS myReporter1 WATCHDOGS myWatchdog1 myWatchdog2");
      //startup.parse("CREATE SENSOR POSITION mySensor16 GROUP myGroup1 REPORTERS myReporter1 WATCHDOGS myWatchdog1 myWatchdog2 MAPPER myMapper1");

      startup.parse("SET SENSOR mySensor8 VALUE 35");

      //startup.parse("GET SENSOR mySensor VALUE");

      // Meta Commands

      // Clock
      //startup.parse("@CLOCK PAUSE");
      //startup.parse("@CLOCK RESUME");

      //startup.parse("@CLOCK ONESTEP");
      //startup.parse("@CLOCK ONESTEP 5");

      //startup.parse("@CLOCK SET RATE 20");

      //startup.parse("@CLOCK");

      //startup.parse("@CLOCK WAIT FOR 1.5");

      //startup.parse("@CLOCK WAIT UNTIL 2.5");

      // Run
      //startup.parse("@RUN myfilename.mvt");

      // Exit
      startup.parse("@exit");
   }
   
   // -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
   private void parse(final String parse) throws Exception
   {
      System.out.println("PARSE> "+ parse);
      
      Parser parser = new Parser(_parserHelper, parse);
      
      parser.parse();
   }
}
