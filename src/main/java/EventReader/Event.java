package EventReader;

public class Event implements Comparable<Event>{

    String timestamp;
    String eventLog;
    String type;

    Event(){
    }
    Event(String timestamp, String msg){
        this.timestamp = timestamp;
        this.eventLog = msg;
    }


    public void setLastOccurance(){

    }

    @Override
    public int compareTo(Event e) {
        return (int)( Integer.parseInt(e.getTimestamp()) - Integer.parseInt(this.timestamp) );
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getEventLog() {
        return eventLog;
    }

    public void setEventLog(String eventLog) {
        this.eventLog = eventLog;
    }
}

