public abstract class SessionPolicy {

    protected final int duration;

    public SessionPolicy(int duration) {
        this.duration = duration;
    }

    public static SessionPolicy createPolicy(int durationInMinutes, Session.Type type) {
        if (type.equals(Session.Type.Morning))
            return new MorningSessionPolicy(durationInMinutes);
        else if (type.equals(Session.Type.Afternoon)) {
            return new AfternoonSessionPolicy(durationInMinutes);
        }
        throw new IllegalArgumentException("The session type is not recognized");
    }

    public int totalDurationMinutes() {
        return duration;
    }

    protected int remaining(int assigned) {
        return duration - assigned;
    }

    abstract boolean canAddTalkToSession(Session session, Talk talk);

}
