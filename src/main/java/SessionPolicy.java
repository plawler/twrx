public interface SessionPolicy {

    boolean isFilled(Session session);
    boolean acceptsLightning();

}
