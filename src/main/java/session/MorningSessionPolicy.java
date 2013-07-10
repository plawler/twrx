package session;

import schedulable.Schedulable;
import schedulable.Talk;

class MorningSessionPolicy extends SessionPolicy {

    MorningSessionPolicy(int duration) {
        super(duration);
    }

    public boolean canAddTalkToSession(Session session, Schedulable talk) {
        return !((Talk)talk).isLightning() && remaining(session.scheduledAmount()) >= talk.getDuration();
        // may need to do a modulo check between talk block count and difference of MAX and session
        // in other words, do the blocks remaining allow for another set of talks to fulfill the session given that lightning is not accepted
    }

}
