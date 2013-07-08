/**
 * Created with IntelliJ IDEA.
 * User: plawler
 * Date: 7/7/13
 * Time: 9:59 AM
 * To change this template use File | Settings | File Templates.
 */
public class Meal implements Schedulable {

    @Override
    public int blocks() {
        return 4;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getDuration() {
        return 60;
    }

    @Override
    public String getName() {
        return "Lunch";
    }

}
