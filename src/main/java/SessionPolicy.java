import java.util.Comparator;

public interface SessionPolicy {

    boolean isFilled(int blocks);
    boolean canAddTalkToSession(Session session, Talk talk);

}
