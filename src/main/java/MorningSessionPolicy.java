class MorningSessionPolicy implements SessionPolicy {

    private final int duration;

    private MorningSessionPolicy(int duration) {
        this.duration = duration;
    }

    public static SessionPolicy createPolicy(int durationInMinutes) {
        return new MorningSessionPolicy(durationInMinutes);
    }

    public boolean canAddTalkToSession(Session session, Talk talk) {
        return !talk.isLightning() && timeRemaining(session.scheduledAmount()) >= talk.getDuration();
        // may need to do a modulo check between talk block count and difference of MAX and session
        // in other words, do the blocks remaining allow for another set of talks to fulfill the session given that lightning is not accepted
    }

    @Override
    public int totalDurationMinutes() {
        return duration;
    }

    private int timeRemaining(int blocks) {
        return duration - blocks;
    }

}
