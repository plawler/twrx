package schedulable;

import conference.Schedule;

import java.util.Date;

public interface Schedulable extends Comparable<Schedulable>{

    int getDuration();
    String getName();

    Date canBeginAt();

}
