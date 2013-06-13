import spock.lang.Shared
import spock.lang.Specification

class SessionPolicySpec extends Specification {

    def morning = new MorningSessionPolicy()
    def afternoon = new AfternoonSessionPolicy();

    def "accept lightning"() {
        expect:
        !morning.acceptsLightning()
        afternoon.acceptsLightning()
    }

}
