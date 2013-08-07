import conference.Conference
import schedulable.Talk
import session.Session
import session.SessionImpl
import session.SessionPolicy
import spock.lang.Specification

class SessionPolicySpec extends Specification {

    def morning = SessionPolicy.createPolicy(Conference.MORNING_SESSION_DURATION_MINUTES, Session.Type.Morning)
    def afternoon = SessionPolicy.createPolicy(Conference.AFTERNOON_SESSION_DURATION_MINUTES, Session.Type.Afternoon);

    def "morning policy should determine if a talk can be added"() {
        setup:
        def timeToFill = 30
        def session = Mock(Session)
        session.scheduledAmount() >> morning.totalDurationMinutes() - timeToFill

        expect:
        !morning.canAddTalkToSession(session, new Talk("Domain Driven Design", 45, false))
        morning.canAddTalkToSession(session, new Talk("Domain Driven Design", 30, false))
        morning.canAddTalkToSession(session, new Talk("Domain Driven Design Quickly", 5, true))
    }

    def "afternoon policy should determine if a talk can be added"() {
        setup:
        def session = new SessionImpl(afternoon)

        (1..5).each {
            session.add(new Talk("A Talk", 45, false))
        }

        expect:
        !afternoon.canAddTalkToSession(session, new Talk("Domain Driven Design", 45, false))
        afternoon.canAddTalkToSession(session, new Talk("Domain Driven Design Quickly", 5, true))
    }

}
