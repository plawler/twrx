package schedulable;

public class Talk implements Schedulable {

    private final String name;
    private final int duration;
    private final boolean lightning;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Talk talk = (Talk) o;

        if (duration != talk.duration) return false;
        if (lightning != talk.lightning) return false;
        if (!name.equals(talk.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + duration;
        result = 31 * result + (lightning ? 1 : 0);
        return result;
    }

    @Override
    public int compareTo(Schedulable talk) {
        return Boolean.valueOf(this.isLightning()).compareTo(((Talk)talk).isLightning());
    }
}
