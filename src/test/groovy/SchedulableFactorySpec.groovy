import spock.lang.Specification

/**
 * Created with IntelliJ IDEA.
 * User: paul
 * Date: 5/5/13
 * Time: 5:06 PM
 * To change this template use File | Settings | File Templates.
 */
class SchedulableFactorySpec extends Specification {

    def "parse a normal time"() {
        given:
        def rawTalk = "A World Without HackerNews 30min";

        expect:
        SchedulableFactory.duration(rawTalk).equals("30")
    }

    def "parse a lightning"() {
        expect:
        SchedulableFactory.duration("Rails for Python Developers lightning").equals("5")
    }

    def "parse the talk name"() {
        expect:
        SchedulableFactory.name("Ruby Errors from Mismatched Gem Versions 45min") == "Ruby Errors from Mismatched Gem Versions"
    }

    def "create new talk"() {
        given:
        def talk = SchedulableFactory.createTalk("Ruby on Rails: Why We Should Move On 60min")

        expect:
        talk.name == "Ruby on Rails: Why We Should Move On"
        talk.duration == 60
        talk.blocks() == 4
    }

    def "create new lightning talk"() {
        given:
        def talk = SchedulableFactory.createTalk "Rails for Python Developers lightning"

        expect:
        talk.lightning
        talk.name == "Rails for Python Developers"
        talk.duration == 5
        talk.blocks() == 1
    }
}
