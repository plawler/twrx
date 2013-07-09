public class ConferenceSessionFactory {

    public static Session createInstance(Session.Type type) {
        SessionPolicy policy;
        if (type.equals(Session.Type.Morning)) {
            policy = MorningSessionPolicy.createPolicy(Conference.MORNING_SESSION_DURATION_MINUTES);
        } else {
            policy = AfternoonSessionPolicy.createPolicy(Conference.AFTERNOON_SESSION_DURATION_MINUTES);
        }
        return new SessionImpl(policy);
    }

}
