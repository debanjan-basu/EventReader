package EventReader;

import org.apache.log4j.Logger;

import java.util.StringTokenizer;

public class EventLineParser {

    static Logger logger = Logger.getLogger(EventLineParser.class);

    public void parse(String s) {

        StringBuilder msgBuilder = new StringBuilder();
        String eventType = null;
        String timestamp = null;

        StringTokenizer st = new StringTokenizer(s);
        while (st.hasMoreTokens()) {
            timestamp = (st.nextToken());
            eventType = (st.nextToken());
            break;
        }
        while(st.hasMoreTokens()){
            msgBuilder.append(" ");
            msgBuilder.append(st.nextToken());
        }
        try {
            EventProcessor.processEvents(eventType, timestamp, msgBuilder.toString());
        }
        catch (Exception e){
            logger.debug(e.getMessage());
        }
    }
}
