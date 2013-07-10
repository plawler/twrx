package schedulable;

public interface Schedulable extends Comparable<Schedulable> {

    int getDuration();
    String getName();

}
