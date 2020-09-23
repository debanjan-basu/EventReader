package EventReader;

import org.apache.log4j.Logger;

public class EventProcessor {

    static Logger logger = Logger.getLogger(EventProcessor.class);
    static MostRecent mostRecent = new MostRecent();

    public static void processEvents(String eventType, String timestamp, String msg){

        Event ev = null;

        if (eventType.equals("ALARM")){
            Alarm e  = new Alarm(timestamp, msg);
            e.setCount();
            e.setLastOccurrence(timestamp, msg);
            ev = e;
        }
        else if (eventType.equals("ENDED")){
            Ended e = new Ended(timestamp, msg);
            e.setCount();
            e.setLastOccurrence(timestamp, msg);
            ev = e;
        }
        else if (eventType.equals("FAILURE")){
            Failure e = new Failure(timestamp, msg);
            e.setCount();
            e.setLastOccurrence(timestamp, msg);
            ev = e;
        }
        else if (eventType.equals("INFO")){
           Info e = new Info(timestamp, msg);
           e.setCount();
           e.setLastOccurrence(timestamp, msg);
           ev = e;
        }
        else if (eventType.equals("STARTED")){
            Started e = new Started(timestamp, msg);
            e.setCount();
            e.setLastOccurrence(timestamp, msg);
            ev = e;
        }
        else if (eventType.equals("TRACE")){
            Trace e = new Trace(timestamp, msg);
            e.setCount();
            e.setLastOccurrence(timestamp, msg);
            ev = e;
        }
        else if (eventType.equals("WARN")){
            Warn e = new Warn(timestamp, msg);
            e.setCount();
            e.setLastOccurrence(timestamp, msg);
            ev = e;
        }

        mostRecent.add(ev);
    }

    public static void setEventParams(Event e, String timestamp, String msg ){
        e.setTimestamp(timestamp);
        e.setEventLog(msg);
        mostRecent.add(e);

    }
}
