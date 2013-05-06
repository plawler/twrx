import spock.lang.Specification

/**
 * Created with IntelliJ IDEA.
 * User: paul
 * Date: 5/5/13
 * Time: 12:47 PM
 * To change this template use File | Settings | File Templates.
 */
class SchedulerSpec extends Specification {

    def "creates a schedule for a conference"() {
        given:
        def morning = ConferenceSessionFactory.createInstance(Session.Type.Morning)
        def afternoon = ConferenceSessionFactory.createInstance(Session.Type.Afternoon)
    }
}
