import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: paul
 * Date: 5/5/13
 * Time: 9:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class Conference {

    private String name;
    private List<Track> tracks;

    Conference(String name) {
        this.name = name;
        this.tracks = new ArrayList<Track>();
    }

    List<Track> tracks() {
        return tracks;
    }

    Schedule createSchedule() {
        return new Schedule();
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
}
