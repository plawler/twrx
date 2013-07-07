class AfternoonSessionPolicy implements SessionPolicy {

    static final int MIN_NUM_BLOCKS = 12;
    static final int MAX_NUM_BLOCKS = 16;

    @Override
    public boolean isFilled(int blocks) {
        return blocks >= MIN_NUM_BLOCKS && blocks <= MAX_NUM_BLOCKS;
    }

    @Override
    public boolean canAddTalkToSession(Session session, Talk talk) {
        return blocksRemaining(session.blocks()) >= talk.blocks();
    }

    private int blocksRemaining(int blocks) {
        return MAX_NUM_BLOCKS - blocks;
    }

}
