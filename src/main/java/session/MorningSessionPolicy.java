package session;

import schedulable.Schedulable;
import schedulable.Talk;

class MorningSessionPolicy extends SessionPolicy {

    MorningSessionPolicy(int duration) {
        super(duration);
    }

    public boolean canAddTalkToSession(Session session, Schedulable talk) {
        return remaining(session.scheduledAmount()) >= talk.getDuration();
    }

}
