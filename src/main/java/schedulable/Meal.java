package schedulable;

import java.util.Calendar;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: plawler
 * Date: 7/7/13
 * Time: 9:59 AM
 * To change this template use File | Settings | File Templates.
 */
public class Meal implements Schedulable {

    @Override
    public int getDuration() {
        return 60;
    }

    @Override
    public String getName() {
        return "Lunch";
    }

    @Override
    public Date canBeginAt() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 12);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    @Override
    public int compareTo(Schedulable o) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
