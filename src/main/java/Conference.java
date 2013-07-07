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

    Schedule createSchedule() {
        return new Schedule();
    }

    public void build(Set<Talk> talks) {
        Set<Schedulable> scheduled = new HashSet<Schedulable>();
        while (!scheduled.containsAll(talks)) {
            Track track = new Track.Builder(talks).lunch().networking().build();
            tracks.add(track);
            scheduled.addAll(track.talks());
        }
    }
}
