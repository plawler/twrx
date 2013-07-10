public class ConferenceSessionFactory {

    public static Session createInstance(Session.Type type, int sessionDuration) {
        SessionPolicy policy = SessionPolicy.createPolicy(sessionDuration, type);
        return new SessionImpl(policy);
    }

}
