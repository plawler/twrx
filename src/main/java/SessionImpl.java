import java.util.ArrayList;
import java.util.List;

public class SessionImpl implements Session {

    private SessionPolicy policy;
    private List<Talk> talks;

    SessionImpl(SessionPolicy policy) {
        this.policy = policy;
        talks = new ArrayList<Talk>();
    }

    public void addTalk(Talk talk) {
        if (policy.canAddTalkToSession(this, talk)) {
            talks.add(talk);
        } else {
            throw new IllegalStateException("Session is full");
        }
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
