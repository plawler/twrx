import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: paul
 * Date: 5/5/13
 * Time: 9:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class Conference {

    private String name;
    private List<Track> tracks;

    Conference(String name) {
        this.name = name;
    }

    void displaySchedule() {
        System.out.println("Nothing scheduled yet, bro.");
    }
}
