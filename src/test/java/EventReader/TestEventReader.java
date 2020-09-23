package EventReader;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TestEventReader {

    static Logger logger = Logger.getLogger(EventReader.class);

    @Test
    public void testEventReader() throws IOException {

        BasicConfigurator.configure();


        List<String> lines = Files.readAllLines(Paths.get("src/test/java/EventReader/events.txt"));
        lines.parallelStream().forEach(EventReader::handleEvent);
        printResults();
    }

    public static void handleEvent(String s) {
        //logger.debug(s);
        //System.out.println(s);

        try {
            EventLineParser eventLineParser = new EventLineParser();
            eventLineParser.parse(s);
        }
        catch (Exception e){
            logger.error(e.getMessage());
        }
    }

    public static void printResults() {

        EventCount eventCount = new EventCount();


        eventCount.put("ALARM:", Alarm.ecount);
        eventCount.put("ENDED:", Ended.ecount);
        eventCount.put("FAILURE:", Failure.ecount);
        eventCount.put("INFO:", Info.ecount);
        eventCount.put("STARTED:", Started.ecount);
        eventCount.put("TRACE:", Trace.ecount);
        eventCount.put("WARN:", Warn.ecount);
        eventCount.sortByValue(3);



        System.out.println("ALARM:" + Alarm.convertEpochToDate()  +  Alarm.emsg);
        System.out.println("ENDED:" + Ended.convertEpochToDate() + Ended.emsg);
        System.out.println("FAILURE:" + Failure.convertEpochToDate() +  Failure.emsg);
        System.out.println("INFO:" + Info.convertEpochToDate()+ Info.emsg);
        System.out.println("STARTED:" + Started.convertEpochToDate() + Started.emsg);
        System.out.println("TRACE:" + Trace.convertEpochToDate() + Trace.emsg);
        System.out.println("WARN:" + Warn.convertEpochToDate() + Warn.emsg);


        EventProcessor.mostRecent.printMap(5);


    }
}
