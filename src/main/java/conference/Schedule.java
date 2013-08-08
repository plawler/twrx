package conference;

import schedulable.Schedulable;

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
            for (Schedulable schedulable : track.schedulables()) {
                Scheduled scheduled = new Scheduled(schedulable, calendar.getTime());
                scheduledList.add(scheduled);
                calendar.add(Calendar.MINUTE, schedulable.getDuration() + diffMinutes(calendar.getTime(), scheduled.startsAt()));
            }
            scheduledTracks.put("Track " + trackCount, scheduledList);
            trackCount++;
        }
    }

    public void display() {
        for (String key : sortedKeys()) {
            System.out.println(key + ":");
            for (Scheduled scheduled : scheduledTracks.get(key)) {
                System.out.println(scheduled.toString());
            }
            System.out.println();
        }
    }

    private List<String> sortedKeys() {
        List<String> keys = new ArrayList<String>(scheduledTracks.keySet());
        Collections.sort(keys, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        return keys;
    }

    private int diffMinutes(Date current, Date scheduled) {
        Long diff = Long.valueOf((scheduled.getTime() - current.getTime()) / 60000);
        return diff.intValue();
    }
}
