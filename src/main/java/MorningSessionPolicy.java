public class MorningSessionPolicy implements SessionPolicy {

    private static final int MAX_NUM_BLOCKS = 12;

    @Override
    public boolean isFilled(Session session) {
        return false;
    }

    @Override
    public boolean acceptsLightning() {
        return false;
    }

}
