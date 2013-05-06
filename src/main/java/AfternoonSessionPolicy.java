public class AfternoonSessionPolicy implements SessionPolicy {

    @Override
    public boolean isFilled(Session session) {
        return true;
    }

    @Override
    public boolean acceptsLightning() {
        return true;
    }

}
