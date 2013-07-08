import java.util.ArrayList;
import java.util.List;

public class SessionImpl implements Session {

    private final Type type;
    private SessionPolicy policy;
    private List<Talk> talks;

    SessionImpl(Session.Type type, SessionPolicy policy) {
        this.type = type;
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

    public boolean accepting() {
        return policy.isFilled(blocks());
    }

    @Override
    public List<Schedulable> schedulables() {
        List<Schedulable> schedulables = new ArrayList<Schedulable>();
        for (Talk talk : talks) {
            schedulables.add(talk);
        }
        return schedulables;
    }

    @Override
    public int blocks() {
        if (!talks.isEmpty()) {
            int count = 0;
            for (Talk talk : talks) {
                count += talk.blocks(); // this maybe should be talks.minutes
            }
            return count;
        }
        return 0;
    }

}
