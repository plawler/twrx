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
        return minutesRemaining(session.scheduledAmount()) >= talk.getDuration();
    }

    @Override
    public int totalDurationMinutes() {
        return duration;
    }

    private int minutesRemaining(int blocks) {
        return duration - blocks;
    }

}
