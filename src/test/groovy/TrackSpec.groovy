import spock.lang.Shared
import spock.lang.Specification

/**
 * Created with IntelliJ IDEA.
 * User: plawler
 * Date: 7/7/13
 * Time: 12:27 PM
 * To change this template use File | Settings | File Templates.
 */
class TrackSpec extends Specification {

    @Shared talks = [] as Set // use the shared object to test the copy in the builder constructor
    def setupSpec() {
        (1..3).each { iteration ->
            talks.add(new Talk("A Talk" + iteration, 60, false))
        }
        talks.add(new Talk("A Lightning", 5, true))
    }

    def "should build a track with morning session"() {
        setup:
        def t = new Track.Builder(talks).morning().build()

        expect:
        t.talks() != null;
        t.talks().size() == 3
    }

    def "should build a track with an afternoon session"() {
        setup:
        def t = new Track.Builder(talks).afternoon().build()

        expect:
        t.talks() != null
        t.talks().size() == 4
    }

    def "should build a track with both morning and afternoon sessions"() {
        setup:
        println talks.size()
        def track = new Track.Builder(talks).morning().afternoon().build()
        println talks.size()

        expect:
        track.talks().size() == 4
        track.morning().size() == 3
        track.afternoon().size() == 1
        ((Talk) track.afternoon()[0]).isLightning()
    }
}
