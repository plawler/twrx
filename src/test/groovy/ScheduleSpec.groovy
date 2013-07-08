import spock.lang.Shared
import spock.lang.Specification


/**
 * Created with IntelliJ IDEA.
 * User: plawler
 * Date: 7/7/13
 * Time: 5:33 PM
 * To change this template use File | Settings | File Templates.
 */
class ScheduleSpec extends Specification {

    @Shared Conference conference
    def setupSpec() {
        def talks = [] as Set
        def rawTalks = ["Writing Fast Tests Against Enterprise Rails 60min",
                "Overdoing it in Python 45min",
                "Lua for the Masses 30min",
                "Ruby Errors from Mismatched Gem Versions 45min",
                "Common Ruby Errors 45min",
                "Rails for Python Developers lightning",
                "Communicating Over Distance 60min",
                "Accounting-Driven Development 45min",
                "Woah 30min",
                "Sit Down and Write 30min",
                "Pair Programming vs Noise 45min",
                "Rails Magic 60min",
                "Ruby on Rails: Why We Should Move On 60min",
                "Clojure Ate Scala (on my project) 45min",
                "Programming in the Boondocks of Seattle 30min",
                "Ruby vs. Clojure for Back-End Development 30min",
                "Ruby on Rails Legacy App Maintenance 60min",
                "A World Without HackerNews 30min",
                "User Interface CSS in Rails Apps 30min"]

        rawTalks.each { raw ->
            talks.add(SchedulableFactory.createTalk(raw))
        }

        conference = new Conference("Thoughtworks Conference")
        conference.build(talks)

    }

    def "test some date time stuff"() {
        setup:
        def cal = Calendar.getInstance()
        cal.set(Calendar.HOUR_OF_DAY, 9)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)

        def schedule = new Schedule(conference)

        when:
        schedule.createSchedule()

        then:
        schedule.display()

    }

}
