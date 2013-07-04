import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: paul
 * Date: 5/5/13
 * Time: 9:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class Track {

    private final List<Session> sessions; // perhaps a map instead?

    Track(List<Session> sessions) {
        this.sessions = sessions;
    }
}
