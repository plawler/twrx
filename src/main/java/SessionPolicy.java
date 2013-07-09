import java.util.Comparator;

public interface SessionPolicy {

    boolean canAddTalkToSession(Session session, Talk talk);
    int totalDurationMinutes();

}
