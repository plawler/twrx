import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class ScheduleRunner {

    public static void main(String[] args) throws IOException {
        Conference conference = new Conference("The 2013 ThoughWorks Conference");

        BufferedReader reader = new BufferedReader(new FileReader("talks.txt"));
        try {
            Set<Schedulable> talks = new HashSet<Schedulable>();
            String line;
            while ((line = reader.readLine()) != null) {
                talks.add(SchedulableFactory.createTalk(line));
            }
//            Scheduler.schedule(conference, talks);
            conference.displaySchedule();
        }
        finally {
            reader.close();
        }
    }

}
