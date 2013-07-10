package schedulable;

import schedulable.Schedulable;

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
    public int compareTo(Schedulable o) {
        return 0;
    }
}
