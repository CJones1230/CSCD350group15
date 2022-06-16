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
      
//      // this command must come first. The filenames do not matter here
//      startup.parse("@CONFIGURE LOG \"a.txt\" DOT SEQUENCE \"b.txt\" NETWORK \"c.txt\" XML \"d.txt\"");
//
//      // run your tests like this
//
//      // PART 1 TESTS
//
//      // Mapper Commands
//      // startup.parse("CREATE MAPPER myMapper EQUATION PASSTHROUGH");
//
//       // startup.parse("CREATE MAPPER myMapper1 EQUATION SCALE 10");
//
//      // startup.parse("CREATE MAPPER myMapper2 EQUATION NORMALIZE 10 20");
//
//      // startup.parse("CREATE MAPPER myMapper3 INTERPOLATION LINEAR DEFINITION \"mapfile.map\"");
//      // startup.parse("CREATE MAPPER myMapper4 INTERPOLATION SPLINE DEFINITION \"C:/temp/definition.map\"");
//
//      // Reporter Commands
//       startup.parse("CREATE REPORTER CHANGE myReporter1 NOTIFY IDS myActuator1 mySensor1 DELTA 3");
//
//      //startup.parse("CREATE REPORTER FREQUENCY myReporter6 NOTIFY IDS myActuator1 myActuator2 GROUPS myGroup3 FREQUENCY 4");
//
//      // Watchdog Commands
//       //startup.parse("CREATE WATCHDOG BAND myWatchdog1 MODE INSTANTANEOUS THRESHOLD LOW 1 HIGH 60");
//       //startup.parse("CREATE WATCHDOG NOTCH myWatchdog2 MODE AVERAGE 10 THRESHOLD LOW 1 HIGH 50 GRACE 4");
//
//      // startup.parse("CREATE WATCHDOG LOW myWatchdog3 MODE STANDARD DEVIATION THRESHOLD 3 GRACE 4");
//      // startup.parse("CREATE WATCHDOG HIGH myWatchdog4 MODE STANDARD DEVIATION 10 THRESHOLD 3 GRACE 4");
//
//      // Sensor Commands
//      startup.parse("CREATE SENSOR POSITION mySensor1 GROUP myGroup1 REPORTERS myReporter1");
//      //startup.parse("CREATE SENSOR POSITION mySensor16 GROUP myGroup1 REPORTERS myReporter1 WATCHDOGS myWatchdog1 myWatchdog2 MAPPER myMapper1");
//
//      // Actuator Commands
//      //startup.parse("CREATE ACTUATOR LINEAR myActuator1 ACCELERATION LEADIN 0.1 LEADOUT -0.2 RELAX 0.3 VELOCITY LIMIT 5 VALUE MIN 1 MAX 60 INITIAL 2 JERK LIMIT 15");
//      startup.parse("CREATE ACTUATOR ROTARY myActuator1 SENSORS mySensor1 ACCELERATION LEADIN 0.1 LEADOUT -0.2 RELAX 0.3 VELOCITY LIMIT 5 VALUE MIN 1 MAX 45 INITIAL 2 JERK LIMIT 15");
//
//      // Network Commands
//      // startup.parse("BUILD NETWORK WITH COMPONENT myController");
//      //startup.parse("BUILD NETWORK WITH COMPONENTS myController myActuator0 myActuator1 mySensor16");
//
//      //startup.parse("SET SENSOR mySensor8 VALUE 35");
//
//      //startup.parse("GET SENSOR mySensor8 VALUE");
//
//      // Message Commands
//      //startup.parse("SEND MESSAGE PING");
//
//       //startup.parse("SEND MESSAGE ID myActuator1 POSITION REQUEST 10");
//       //startup.parse("SEND MESSAGE GROUPS myActuators1 myActuators2 POSITION REQUEST 20");
//      //startup.parse("SEND MESSAGE ID myActuator1 GROUPS myGroup1 POSITION REQUEST 31");
//
//      //startup.parse("SEND MESSAGE ID myActuator1 POSITION REPORT");
//      //startup.parse("SEND MESSAGE GROUPS myActuators0 myActuators1 POSITION REPORT");
//      //startup.parse("SEND MESSAGE ID myActuator1 GROUPS myActuators0 myActuators1 POSITION REPORT");
//
//      // Meta Commands
//      // Clock
//      //startup.parse("@CLOCK PAUSE");
//      //startup.parse("@CLOCK RESUME");
//
//      //startup.parse("@CLOCK ONESTEP");
//      //startup.parse("@CLOCK ONESTEP 5");
//
//      //startup.parse("@CLOCK SET RATE 20");
//
//      //startup.parse("@CLOCK");
//
//      //startup.parse("@CLOCK WAIT FOR 1.5");
//
//      //startup.parse("@CLOCK WAIT UNTIL 2.5");
//
//      // Run
//      //startup.parse("@RUN myfilename.mvt");
//
//      // PART 2 TESTS
       startup.parse("@CONFIGURE LOG \"a.txt\" DOT SEQUENCE \"b.txt\" NETWORK \"c.txt\" XML \"d.txt\"");
      //startup.parse("// mappers");
      startup.parse("CREATE MAPPER myMapper1 EQUATION PASSTHROUGH");
      startup.parse("CREATE MAPPER myMapper2 EQUATION SCALE 10");
      startup.parse("CREATE MAPPER myMapper3 EQUATION NORMALIZE 1 10");
      //startup.parse("CREATE MAPPER myMapper4 INTERPOLATION LINEAR DEFINITION \"/home/dtappan/development/eclipse/CS350-22S/mapping.map\"");
      //startup.parse("CREATE MAPPER myMapper5 INTERPOLATION SPLINE DEFINITION \"/home/dtappan/development/eclipse/CS350-22S/mapping.map\"");
      //startup.parse("// reporters");
      startup.parse("CREATE REPORTER CHANGE myReporter1 NOTIFY IDS myActuator1 myActuator2 DELTA 3");
      startup.parse("CREATE REPORTER CHANGE myReporter2 NOTIFY GROUPS myGroup1 myGroup2 DELTA 4");
      startup.parse("CREATE REPORTER CHANGE myReporter3 NOTIFY IDS myActuator1 myActuator2 GROUPS myGroup3 DELTA 4");
      startup.parse("CREATE REPORTER FREQUENCY myReporter4 NOTIFY IDS myActuator1 myActuator2 FREQUENCY 3");
      startup.parse("CREATE REPORTER FREQUENCY myReporter5 NOTIFY GROUPS myGroup1 myGroup2 FREQUENCY 4");
      startup.parse("CREATE REPORTER FREQUENCY myReporter6 NOTIFY IDS myActuator1 myActuator2 GROUPS myGroup3 FREQUENCY 4");
      //startup.parse("// watchdogs");
      startup.parse("CREATE WATCHDOG ACCELERATION myWatchdog1 MODE INSTANTANEOUS THRESHOLD LOW 1 HIGH 3");
      startup.parse("CREATE WATCHDOG ACCELERATION myWatchdog2 MODE INSTANTANEOUS THRESHOLD LOW 1 HIGH 3 GRACE 4");
      startup.parse("CREATE WATCHDOG ACCELERATION myWatchdog3 MODE AVERAGE THRESHOLD LOW 1 HIGH 3");
      startup.parse("CREATE WATCHDOG ACCELERATION myWatchdog4 MODE AVERAGE THRESHOLD LOW 1 HIGH 3 GRACE 4");
      startup.parse("CREATE WATCHDOG ACCELERATION myWatchdog5 MODE AVERAGE 10 THRESHOLD LOW 1 HIGH 3");
      startup.parse("CREATE WATCHDOG ACCELERATION myWatchdog6 MODE AVERAGE 10 THRESHOLD LOW 1 HIGH 3 GRACE 4");
      startup.parse("CREATE WATCHDOG ACCELERATION myWatchdog7 MODE STANDARD DEVIATION THRESHOLD LOW 1 HIGH 3");
      startup.parse("CREATE WATCHDOG ACCELERATION myWatchdog8 MODE STANDARD DEVIATION THRESHOLD LOW 1 HIGH 3 GRACE 4");
      startup.parse("CREATE WATCHDOG ACCELERATION myWatchdog9 MODE STANDARD DEVIATION 10 THRESHOLD LOW 1 HIGH 3");
      startup.parse("CREATE WATCHDOG ACCELERATION myWatchdog10 MODE STANDARD DEVIATION 10 THRESHOLD LOW 1 HIGH 3 GRACE 4");
      startup.parse("CREATE WATCHDOG BAND myWatchdog11 MODE INSTANTANEOUS THRESHOLD LOW 1 HIGH 3");
      startup.parse("CREATE WATCHDOG BAND myWatchdog12 MODE INSTANTANEOUS THRESHOLD LOW 1 HIGH 3 GRACE 4");
      startup.parse("CREATE WATCHDOG BAND myWatchdog13 MODE AVERAGE THRESHOLD LOW 1 HIGH 3");
      startup.parse("CREATE WATCHDOG BAND myWatchdog14 MODE AVERAGE THRESHOLD LOW 1 HIGH 3 GRACE 4");
      startup.parse("CREATE WATCHDOG BAND myWatchdog15 MODE AVERAGE 10 THRESHOLD LOW 1 HIGH 3");
      startup.parse("CREATE WATCHDOG BAND myWatchdog16 MODE AVERAGE 10 THRESHOLD LOW 1 HIGH 3 GRACE 4");
      startup.parse("CREATE WATCHDOG BAND myWatchdog17 MODE STANDARD DEVIATION THRESHOLD LOW 1 HIGH 3");
      startup.parse("CREATE WATCHDOG BAND myWatchdog18 MODE STANDARD DEVIATION THRESHOLD LOW 1 HIGH 3 GRACE 4");
      startup.parse("CREATE WATCHDOG BAND myWatchdog19 MODE STANDARD DEVIATION 10 THRESHOLD LOW 1 HIGH 3");
      startup.parse("CREATE WATCHDOG BAND myWatchdog20 MODE STANDARD DEVIATION 10 THRESHOLD LOW 1 HIGH 3 GRACE 4");
      startup.parse("CREATE WATCHDOG NOTCH myWatchdog21 MODE INSTANTANEOUS THRESHOLD LOW 1 HIGH 3");
      startup.parse("CREATE WATCHDOG NOTCH myWatchdog22 MODE INSTANTANEOUS THRESHOLD LOW 1 HIGH 3 GRACE 4");
      startup.parse("CREATE WATCHDOG NOTCH myWatchdog23 MODE AVERAGE THRESHOLD LOW 1 HIGH 3");
      startup.parse("CREATE WATCHDOG NOTCH myWatchdog24 MODE AVERAGE THRESHOLD LOW 1 HIGH 3 GRACE 4");
      startup.parse("CREATE WATCHDOG NOTCH myWatchdog25 MODE AVERAGE 10 THRESHOLD LOW 1 HIGH 3");
      startup.parse("CREATE WATCHDOG NOTCH myWatchdog26 MODE AVERAGE 10 THRESHOLD LOW 1 HIGH 3 GRACE 4");
      startup.parse("CREATE WATCHDOG NOTCH myWatchdog27 MODE STANDARD DEVIATION THRESHOLD LOW 1 HIGH 3");
      startup.parse("CREATE WATCHDOG NOTCH myWatchdog28 MODE STANDARD DEVIATION THRESHOLD LOW 1 HIGH 3 GRACE 4");
      startup.parse("CREATE WATCHDOG NOTCH myWatchdog29 MODE STANDARD DEVIATION 10 THRESHOLD LOW 1 HIGH 3");
      startup.parse("CREATE WATCHDOG NOTCH myWatchdog30 MODE STANDARD DEVIATION 10 THRESHOLD LOW 1 HIGH 3 GRACE 4");
      startup.parse("CREATE WATCHDOG LOW myWatchdog31 MODE INSTANTANEOUS THRESHOLD 3");
      startup.parse("CREATE WATCHDOG LOW myWatchdog32 MODE INSTANTANEOUS THRESHOLD 3 GRACE 4");
      startup.parse("CREATE WATCHDOG LOW myWatchdog33 MODE AVERAGE THRESHOLD 3");
      startup.parse("CREATE WATCHDOG LOW myWatchdog34 MODE AVERAGE THRESHOLD 3 GRACE 4");
      startup.parse("CREATE WATCHDOG LOW myWatchdog35 MODE AVERAGE 10 THRESHOLD 3");
      startup.parse("CREATE WATCHDOG LOW myWatchdog36 MODE AVERAGE 10 THRESHOLD 3 GRACE 4");
      startup.parse("CREATE WATCHDOG LOW myWatchdog37 MODE STANDARD DEVIATION THRESHOLD 3");
      startup.parse("CREATE WATCHDOG LOW myWatchdog38 MODE STANDARD DEVIATION THRESHOLD 3 GRACE 4");
      startup.parse("CREATE WATCHDOG LOW myWatchdog39 MODE STANDARD DEVIATION 10 THRESHOLD 3");
      startup.parse("CREATE WATCHDOG LOW myWatchdog40 MODE STANDARD DEVIATION 10 THRESHOLD 3 GRACE 4");
      startup.parse("CREATE WATCHDOG HIGH myWatchdog41 MODE INSTANTANEOUS THRESHOLD 3");
      startup.parse("CREATE WATCHDOG HIGH myWatchdog42 MODE INSTANTANEOUS THRESHOLD 3 GRACE 4");
      startup.parse("CREATE WATCHDOG HIGH myWatchdog43 MODE AVERAGE THRESHOLD 3");
      startup.parse("CREATE WATCHDOG HIGH myWatchdog44 MODE AVERAGE THRESHOLD 3 GRACE 4");
      startup.parse("CREATE WATCHDOG HIGH myWatchdog45 MODE AVERAGE 10 THRESHOLD 3");
      startup.parse("CREATE WATCHDOG HIGH myWatchdog46 MODE AVERAGE 10 THRESHOLD 3 GRACE 4");
      startup.parse("CREATE WATCHDOG HIGH myWatchdog47 MODE STANDARD DEVIATION THRESHOLD 3");
      startup.parse("CREATE WATCHDOG HIGH myWatchdog48 MODE STANDARD DEVIATION THRESHOLD 3 GRACE 4");
      startup.parse("CREATE WATCHDOG HIGH myWatchdog49 MODE STANDARD DEVIATION 10 THRESHOLD 3");
      startup.parse("CREATE WATCHDOG HIGH myWatchdog50 MODE STANDARD DEVIATION 10 THRESHOLD 3 GRACE 4");
      //startup.parse("// sensors");
      startup.parse("CREATE SENSOR POSITION mySensor1");
      startup.parse("CREATE SENSOR POSITION mySensor2 GROUP myGroup1");
      startup.parse("CREATE SENSOR POSITION mySensor3 GROUP myGroup1 myGroup2");
      startup.parse("CREATE SENSOR POSITION mySensor4 MAPPER myMapper1");
      startup.parse("CREATE SENSOR POSITION mySensor5 GROUP myGroup1 REPORTERS myReporter1");
      startup.parse("CREATE SENSOR POSITION mySensor6 GROUP myGroup1 REPORTERS myReporter1");
      startup.parse("CREATE SENSOR POSITION mySensor7 GROUP myGroup1 myGroup2 REPORTERS myReporter1");
      startup.parse("CREATE SENSOR POSITION mySensor8 GROUP myGroup1 REPORTERS myReporter1 MAPPER myMapper1");
      startup.parse("CREATE SENSOR POSITION mySensor9 GROUP myGroup1 WATCHDOG myWatchdog1");
      startup.parse("CREATE SENSOR POSITION mySensor10 GROUP myGroup1 WATCHDOG myWatchdog1");
      startup.parse("CREATE SENSOR POSITION mySensor11 GROUP myGroup1 myGroup2 WATCHDOGS myWatchdog1");
      startup.parse("CREATE SENSOR POSITION mySensor12 GROUP myGroup1 WATCHDOGS myWatchdog1 myWatchdog2 MAPPER myMapper1");
      startup.parse("CREATE SENSOR POSITION mySensor13 GROUP myGroup1 REPORTERS myReporter1 WATCHDOGS myWatchdog1");
      startup.parse("CREATE SENSOR POSITION mySensor15 GROUP myGroup1 myGroup2 REPORTERS myReporter1 WATCHDOGS myWatchdog1");
      startup.parse("CREATE SENSOR POSITION mySensor16 GROUP myGroup1 REPORTERS myReporter1 WATCHDOGS myWatchdog1 myWatchdog2 MAPPER myMapper1");
      //startup.parse("// actuators");
      startup.parse("CREATE ACTUATOR LINEAR myActuator0 ACCELERATION LEADIN 0.1 LEADOUT -0.2 RELAX 0.3 VELOCITY LIMIT 5 VALUE MIN 1 MAX 10 INITIAL 2 JERK LIMIT 3");
      startup.parse("CREATE ACTUATOR LINEAR myActuator1 ACCELERATION LEADIN 0.1 LEADOUT -0.2 RELAX 0.3 VELOCITY LIMIT 5 VALUE MIN 1 MAX 10 INITIAL 2 JERK LIMIT 3");
      startup.parse("CREATE ACTUATOR LINEAR myActuator2 GROUP myGroup3 ACCELERATION LEADIN 0.1 LEADOUT -0.2 RELAX 0.3 VELOCITY LIMIT 5 VALUE MIN 1 MAX 10 INITIAL 2 JERK LIMIT 3");
      startup.parse("CREATE ACTUATOR LINEAR myActuator3 GROUP myGroup3 SENSORS mySensor1 mySensor2 ACCELERATION LEADIN 0.1 LEADOUT -0.2 RELAX 0.3 VELOCITY LIMIT 5 VALUE MIN 1 MAX 10 INITIAL 2 JERK LIMIT 3");
      startup.parse("CREATE ACTUATOR LINEAR myActuator4 SENSORS mySensor3 ACCELERATION LEADIN 0.1 LEADOUT -0.2 RELAX 0.3 VELOCITY LIMIT 5 VALUE MIN 1 MAX 10 INITIAL 2 JERK LIMIT 3");
      startup.parse("CREATE ACTUATOR ROTARY myActuator5 ACCELERATION LEADIN 0.1 LEADOUT -0.2 RELAX 0.3 VELOCITY LIMIT 5 VALUE MIN 1 MAX 10 INITIAL 2 JERK LIMIT 3");
      startup.parse("CREATE ACTUATOR ROTARY myActuator6 GROUP myGroup3 ACCELERATION LEADIN 0.1 LEADOUT -0.2 RELAX 0.3 VELOCITY LIMIT 5 VALUE MIN 1 MAX 10 INITIAL 2 JERK LIMIT 3");
      startup.parse("CREATE ACTUATOR ROTARY myActuator7 GROUP myGroup3 SENSORS mySensor1 mySensor2 ACCELERATION LEADIN 0.1 LEADOUT -0.2 RELAX 0.3 VELOCITY LIMIT 5 VALUE MIN 1 MAX 10 INITIAL 2 JERK LIMIT 3");
      startup.parse("CREATE ACTUATOR ROTARY myActuator8 SENSORS mySensor3 ACCELERATION LEADIN 0.1 LEADOUT -0.2 RELAX 0.3 VELOCITY LIMIT 5 VALUE MIN 1 MAX 10 INITIAL 2 JERK LIMIT 3");
      //startup.parse("// dependency sequence");
//      startup.parse("CREATE DEPENDENCY SEQUENCE myDependencySequence1 EXPRESSION myMessage1");
//      startup.parse("CREATE DEPENDENCY SEQUENCE myDependencySequence2 EXPRESSION ( myMessage1 AND myMessage2 )");
//      startup.parse("CREATE DEPENDENCY SEQUENCE myDependencySequence3 EXPRESSION ( myMessage1 OR myMessage2 )");
//      startup.parse("CREATE DEPENDENCY SEQUENCE myDependencySequence4 EXPRESSION ( (myMessage1 AND myMessage2) OR (myMessage3 AND (myMessage4 OR myMessage5)) )");
      //startup.parse("// dependency sequencer");
//      startup.parse("CREATE DEPENDENCY SEQUENCER myDependencySequencer1 SEQUENCE myDependencySequence1");
//      startup.parse("CREATE DEPENDENCY SEQUENCER myDependencySequencer2 SEQUENCES myDependencySequence2 myDependencySequence3");
      //startup.parse("// send message");
      //startup.parse("SEND MESSAGE PING");
      startup.parse("SEND MESSAGE IDS myActuator1 myActuator2 POSITION REQUEST 123.45");
      startup.parse("SEND MESSAGE IDS myActuator1 myActuator2 GROUP myGroup1 POSITION REQUEST 123.45");
      startup.parse("SEND MESSAGE IDS myActuator1 myActuator2 POSITION REPORT");
      startup.parse("SEND MESSAGE IDS myActuator1 myActuator2 GROUP myGroup1 POSITION REPORT");
      //startup.parse("// meta");

      //startup.parse("@CONFIGURE LOG \"/home/dtappan/staging/log_filename\" DOT SEQUENCE \"/home/dtappan/staging/dot_sequence_filename\" NETWORK \"/home/dtappan/staging/dot_network_filename\" XML \"/home/dtappan/staging/xml_network_filename\"");
      //startup.parse("// build network");
      startup.parse("BUILD NETWORK WITH COMPONENT myActuator0 myController1");
      //System.out.println(parserHelper.toString());

//       // SENSOR TEST
//       startup.parse("@CONFIGURE LOG \"a.txt\" DOT SEQUENCE \"b.txt\" NETWORK \"c.txt\" XML \"d.txt\"");
//       startup.parse("CREATE SENSOR POSITION mySensor0");
//       startup.parse("BUILD NETWORK WITH COMPONENTS myController mySensor0");
//       startup.parse("GET SENSOR mySensor0 VALUE");
//       startup.parse("SET SENSOR mySensor0 VALUE 6");
//       startup.parse("GET SENSOR mySensor0 VALUE");

//       // WATCHDOG TEST
//       startup.parse("@CONFIGURE LOG \"a.txt\" DOT SEQUENCE \"b.txt\" NETWORK \"c.txt\" XML \"d.txt\"");
//       startup.parse("CREATE WATCHDOG LOW myWatchdog0 MODE AVERAGE THRESHOLD -15");
//       startup.parse("CREATE SENSOR POSITION mySensor0 GROUP group0 WATCHDOGS myWatchdog0");
//       startup.parse("BUILD NETWORK WITH COMPONENTS myController mySensor0");
//       startup.parse("SET SENSOR mySensor0 VALUE 100");
//       startup.parse("SET SENSOR mySensor0 VALUE -30");
//       startup.parse("SET SENSOR mySensor0 VALUE -200");


      // Exit
      startup.parse("@exit");
   }
   
   // -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
   private void parse(final String parse) throws Exception
   {
      System.out.println("PARSE>   | " + parse);
      
      Parser parser = new Parser(_parserHelper, parse);
      
      parser.parse();
   }
}
