public class Talk implements Schedulable {

    private String name;
    private int duration;
    private boolean lightning;

    Talk(String name, int duration, boolean lightning) {
        if (duration > 5 && lightning == true) {
            throw new IllegalStateException("lightning talks cannot be longer than 5 minutes");
        }
        this.name = name;
        this.duration = duration;
        this.lightning = lightning;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public boolean isLightning() {
        return lightning;
    }

    @Override
    public int blocks() {
        int size = duration / Scheduler.BLOCK_SIZE;
        if (size < 1) return 1;
        return size;
    }
}
