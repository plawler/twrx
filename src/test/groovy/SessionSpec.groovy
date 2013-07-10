import spock.lang.Specification

/**
 * Created with IntelliJ IDEA.
 * User: plawler
 * Date: 7/7/13
 * Time: 10:42 AM
 * To change this template use File | Settings | File Templates.
 */
class SessionSpec extends Specification {

    def "should return a list of talks with lightning ordered last"() {
        setup:
        def session = new SessionImpl(SessionPolicy.createPolicy(Conference.AFTERNOON_SESSION_DURATION_MINUTES,
                Session.Type.Afternoon))
        session.add(new Talk("Fast Talk", 5, true))
        session.add(new Talk("Talk One", 60, false))
        session.add(new Talk("Talk Two", 60, false))
        session.add(new Talk("Talk Three", 60, false))

        expect:
        session.schedulables().get(3).name == "Fast Talk"
    }
}
