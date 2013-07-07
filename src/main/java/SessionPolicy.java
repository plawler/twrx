public interface SessionPolicy {

    boolean canAddTalkToSession(Session session, Talk talk);

}
