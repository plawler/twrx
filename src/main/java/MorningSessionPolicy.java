class MorningSessionPolicy implements SessionPolicy {

    static final int MAX_NUM_BLOCKS = 12;
    static final int MIN_NUM_BLOCKS = MAX_NUM_BLOCKS;

    public boolean canAddTalkToSession(Session session, Talk talk) {
        return !talk.isLightning() && blocksRemaining(session.blocks()) >= talk.blocks();
        // may need to do a modulo check between talk block count and difference of MAX and session
        // in other words, do the blocks remaining allow for another set of talks to fulfill the session given that lightning is not accepted
    }

    private int blocksRemaining(int blocks) {
        return MAX_NUM_BLOCKS - blocks;
    }

}
