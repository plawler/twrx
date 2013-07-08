import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: paul
 * Date: 5/5/13
 * Time: 9:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class Conference {

    private String name;
    private Schedule schedule;
    private List<Track> tracks;


    Conference(String name) {
        this.name = name;
        this.tracks = new ArrayList<Track>();
    }

    List<Track> tracks() {
        return tracks;
    }

    void createSchedule() {
        if (schedule == null) {
            schedule = new Schedule(this);
            schedule.createSchedule();
        }
    }

    void build(Set<Schedulable> talks) {
        Set<Schedulable> remaining = new HashSet<Schedulable>(talks);
        while (!remaining.isEmpty()) {
            Track track = new Track.Builder(remaining)
                    .morning()
                    .afternoon()
                    .lunch()
                    .networking()
                    .build();
            tracks.add(track);
            remaining.removeAll(track.talks());
        }
    }

    Calendar dayBegins() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 9);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar;
    }

    void displaySchedule() {
        schedule.display();
    }
}
