public class ConferenceSessionFactory {

    public static Session createInstance(Session.Type type) {
        SessionPolicy policy;
        if (type.equals(Session.Type.Morning)) {
            policy = new MorningSessionPolicy();
        } else {
            policy = new AfternoonSessionPolicy();
        }
        return new SessionImpl(policy);
    }

}
