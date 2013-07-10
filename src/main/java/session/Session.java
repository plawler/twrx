package session;


import schedulable.Schedulable;

import java.util.List;

public interface Session {

    enum Type { Morning, Afternoon}

    List<Schedulable> schedulables();

    public int scheduledAmount();
    public void add(Schedulable schedulable);

}
