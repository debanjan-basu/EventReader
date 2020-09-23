package EventReader;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Warn extends Event {
    public static int ecount = 0;
    public static long etimestamp = 0;
    public static String emsg = null;
    public static LastOccurance lo  = new LastOccurance();
    public static Lock lastOccurance = new ReentrantLock();
    public static Lock countLock = new ReentrantLock();

    Warn(){
        super();
    }

    Warn(String timestamp, String msg){
        super(timestamp, msg);
    }

    public void  setLastOccurrence( String timestamp, String msg ){
        lastOccurance.lock();
        try{
            if (Integer.parseInt(timestamp) > etimestamp){
                etimestamp = Long.parseLong(timestamp);
                emsg = new String(msg);
            }
        }
        finally {
            lastOccurance.unlock();
        }
    }

    public void setCount(){
        countLock.lock();
        try {
            ecount++;
        }
        finally {
            countLock.unlock();
        }

    }

    public static String convertEpochToDate(){
        String date = new java.text.SimpleDateFormat("dd-MMM-yyyy HH:mm:ss z").format(new java.util.Date (etimestamp*1000));
        return date;
    }
}
