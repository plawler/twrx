class AfternoonSessionPolicy implements SessionPolicy {

    private final int duration;

    private AfternoonSessionPolicy(int duration) {
        this.duration = duration;
    }

    public static SessionPolicy createPolicy(int durationInMinutes) {
        return new AfternoonSessionPolicy(durationInMinutes);
    }

    @Override
    public boolean canAddTalkToSession(Session session, Talk talk) {
        return remaining(session.scheduledAmount()) >= talk.getDuration();
    }

    @Override
    public int totalDurationMinutes() {
        return duration;
    }

    private int remaining(int minutes) {
        return duration - minutes;
    }

}
