import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: plawler
 * Date: 7/4/13
 * Time: 3:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class Scheduled {

    private final Date startsAt;
    private final String name;
    private final int duration;
    private final boolean talk;
    private final SimpleDateFormat format = new SimpleDateFormat("hh:mma");

    Scheduled(Schedulable schedulable, Date startsAt) {
        this.startsAt = startsAt;
        this.name = schedulable.getName();
        this.duration = schedulable.getDuration();
        this.talk = schedulable instanceof Talk;
    }

    public String toString() {
        String val = format.format(this.startsAt) + " " + name;
        if (talk)
            val += " " + duration + "min";
        return val;
    }

}
