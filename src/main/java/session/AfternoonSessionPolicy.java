package session;

import schedulable.Schedulable;

class AfternoonSessionPolicy extends SessionPolicy {

    AfternoonSessionPolicy(int duration) {
        super(duration);
    }

    @Override
    public boolean canAddTalkToSession(Session session, Schedulable talk) {
        return remaining(session.scheduledAmount()) >= talk.getDuration();
    }

}
