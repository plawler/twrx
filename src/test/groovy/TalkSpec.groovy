import spock.lang.Specification

/**
 * Created with IntelliJ IDEA.
 * User: paul
 * Date: 5/5/13
 * Time: 2:12 PM
 * To change this template use File | Settings | File Templates.
 */
class TalkSpec extends Specification {

    def "calculate blocks"() {
        given:
        def talk = new Talk("Writing Fast Tests Against Enterprise Rails", 60, false)
        def talk2 = new Talk("Overdoing it in Python", 45, false)
        def lightning = new Talk("Rails for Python Developers", 5, true)

        expect:
        talk.blocks() == 4
        talk2.blocks() == 3
        lightning.blocks() == 1
    }

}
