package session;

import schedulable.Schedulable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SessionImpl implements Session {

    private SessionPolicy policy;
    private List<Schedulable> talks;

    SessionImpl(SessionPolicy policy) {
        this.policy = policy;
        talks = new ArrayList<Schedulable>();
    }

    @Override
    public void add(Schedulable schedulable) {
        if (policy.canAddTalkToSession(this, schedulable)) {
            talks.add(schedulable);
        } else {
            throw new IllegalStateException("Session is full");
        }
    }

    @Override
    public List<Schedulable> schedulables() {
        Collections.sort(talks);
        return talks;
    }

    @Override
    public int scheduledAmount() {
        if (!talks.isEmpty()) {
            int count = 0;
            for (Schedulable talk : talks) {
                count += talk.getDuration(); // this maybe should be talks.minutes
            }
            return count;
        }
        return 0;
    }

}
