import conference.Conference
import session.ConferenceSessionFactory
import session.Session
import spock.lang.Specification

/**
 * Created with IntelliJ IDEA.
 * User: paul
 * Date: 5/5/13
 * Time: 12:58 PM
 * To change this template use File | Settings | File Templates.
 */
class ConferenceSessionFactorySpec extends Specification {

    def "creates a new conference session"() {
        setup:
        def morning = ConferenceSessionFactory.createInstance(Session.Type.Morning,
                Conference.MORNING_SESSION_DURATION_MINUTES)

        expect:
        morning != null
    }

}
