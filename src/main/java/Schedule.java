import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: plawler
 * Date: 7/7/13
 * Time: 9:47 AM
 * To change this template use File | Settings | File Templates.
 */
public class Schedule {

    private final Conference conference;
    private Map<String, List<Scheduled>> scheduledTracks;

    Schedule(Conference conference) {
        this.conference = conference;
        this.scheduledTracks = new HashMap<String, List<Scheduled>>();
    }

    void createSchedule() {
        int trackCount = 1;
        for (Track track : conference.tracks()) {
            List<Scheduled> scheduledList = new ArrayList<Scheduled>();
            Calendar calendar = conference.dayBegins();
            for (Schedulable schedulable : track.forScheduling()) {
                scheduledList.add(new Scheduled(schedulable, calendar));
            }
            scheduledTracks.put("Track" + trackCount, scheduledList);
            trackCount++;
        }
    }

}
