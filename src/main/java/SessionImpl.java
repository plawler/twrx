import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SessionImpl implements Session {

    private SessionPolicy policy;
    private List<Talk> talks;

    SessionImpl(SessionPolicy policy) {
        this.policy = policy;
        talks = new ArrayList<Talk>();
    }

    @Override
    public void add(Schedulable schedulable) {
        Talk talk = (Talk) schedulable;
        if (policy.canAddTalkToSession(this, talk)) {
            talks.add(talk);
        } else {
            throw new IllegalStateException("Session is full");
        }
    }

    @Override
    public List<Schedulable> schedulables() {
        List<Talk> schedulables = new ArrayList<Talk>();
        for (Talk talk : talks) {
            schedulables.add(talk);
        }
        Collections.sort(schedulables);
        return (List)schedulables; // i know, i know but can guarantee that schedulable types are the only entries here
    }

    @Override
    public int scheduledAmount() {
        if (!talks.isEmpty()) {
            int count = 0;
            for (Talk talk : talks) {
                count += talk.getDuration(); // this maybe should be talks.minutes
            }
            return count;
        }
        return 0;
    }

}
