import java.util.List;

public interface Session {

    enum Type { Morning, Afternoon}

    List<Schedulable> schedulables();

    public int blocks();
    public void add(Schedulable schedulable);
//    public boolean accepting();

}
