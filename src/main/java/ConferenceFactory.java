import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: plawler
 * Date: 7/7/13
 * Time: 3:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class ConferenceFactory {


    public static Conference createConference(String name, Set<Schedulable> talks) {
        Conference conference = new Conference(name);
        conference.build(talks);
        return conference;
    }
}
