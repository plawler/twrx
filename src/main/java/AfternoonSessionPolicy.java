class AfternoonSessionPolicy extends SessionPolicy {

    AfternoonSessionPolicy(int duration) {
        super(duration);
    }

    @Override
    public boolean canAddTalkToSession(Session session, Talk talk) {
        return remaining(session.scheduledAmount()) >= talk.getDuration();
    }

}
