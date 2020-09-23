package EventReader;

import org.apache.log4j.Logger;

import java.util.Map;
import java.util.TreeMap;

public class MostRecent {

    static Logger logger = Logger.getLogger(EventReader.class);
    TreeMap<Event, Boolean > tmap = new TreeMap<Event, Boolean>();

    public  synchronized void add(Event e){
        tmap.put(e, true);
    }

    public  void printMap(int count) {


        for (Map.Entry<Event, Boolean> entry : tmap.entrySet()) {
            String date = new java.text.SimpleDateFormat("dd-MMM-yyyy HH:mm:ss z").
                    format(new java.util.Date((Long.parseLong(entry.getKey().getTimestamp()))*1000));


            System.out.println("Date : " + date + " Type : "  + entry.getKey().getClass().getSimpleName() + " Msg : " + entry.getKey().getEventLog() );
            count --;
            if (count == 0){
                break;
            }
        }
    }


}
