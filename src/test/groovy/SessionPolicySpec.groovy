import spock.lang.Shared
import spock.lang.Specification

class SessionPolicySpec extends Specification {

    def morning = new MorningSessionPolicy()
    def afternoon = new AfternoonSessionPolicy();

    def "policy should determine if the session is filled"() {
        expect:
        morning.isFilled(MorningSessionPolicy.MAX_NUM_BLOCKS)
        !morning.isFilled(MorningSessionPolicy.MAX_NUM_BLOCKS - 1)
        afternoon.isFilled(AfternoonSessionPolicy.MIN_NUM_BLOCKS)
        afternoon.isFilled(AfternoonSessionPolicy.MAX_NUM_BLOCKS - 1)
        !afternoon.isFilled(AfternoonSessionPolicy.MIN_NUM_BLOCKS - 1)
    }

    def "morning policy should determine if a talk can be added"() {
        setup:
        def blocksToFill = 2
        def session = Mock(Session)
        session.blocks() >> MorningSessionPolicy.MAX_NUM_BLOCKS - blocksToFill

        expect:
        !morning.canAddTalkToSession(session, new Talk("Domain Driven Design", 45, false))
        morning.canAddTalkToSession(session, new Talk("Domain Driven Design", 30, false))
        !morning.canAddTalkToSession(session, new Talk("Domain Driven Design Quickly", 5, true))
    }

    def "afternoon policy should determine if a talk can be added"() {
        setup:
        def durationEqualToABlock = 15
        def session = new SessionImpl(afternoon)
        (1..(AfternoonSessionPolicy.MAX_NUM_BLOCKS - 1)).each {
            session.addTalk(new Talk("A Talk", durationEqualToABlock, false))
        }

        expect:
        afternoon.isFilled(session.blocks())
        !afternoon.canAddTalkToSession(session, new Talk("Domain Driven Design", 45, false))
        afternoon.canAddTalkToSession(session, new Talk("Domain Driven Design Quickly", 5, true))
    }

}
