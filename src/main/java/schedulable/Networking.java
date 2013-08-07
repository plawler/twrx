package schedulable;

import java.util.Calendar;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: plawler
 * Date: 7/7/13
 * Time: 10:29 AM
 * To change this template use File | Settings | File Templates.
 */
public class Networking implements Schedulable {

    @Override
    public int getDuration() {
        return 0;
    }

    @Override
    public String getName() {
        return "Networking Event";
    }

    @Override
    public Date canBeginAt() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 16);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    @Override
    public int compareTo(Schedulable o) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
