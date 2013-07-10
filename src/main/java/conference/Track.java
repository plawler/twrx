package conference;

import schedulable.Meal;
import schedulable.Networking;
import schedulable.Schedulable;
import session.ConferenceSessionFactory;
import session.Session;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: paul
 * Date: 5/5/13
 * Time: 9:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class Track {

    private Map<Session.Type, Session> sessionMap;
    private Meal meal;
    private Networking networking;

    private Track(Builder builder) {
        this.sessionMap = builder.sessions2;
        this.meal = builder.lunch;
        this.networking = builder.networking;
    }

    List<Schedulable> talks() {
        List<Schedulable> talks = new ArrayList<Schedulable>();
        for (Session session : sessionMap.values()) {
            talks.addAll(session.schedulables());
        }
        return talks;
    }

    List<Schedulable> morning() {
        return sessionMap.get(Session.Type.Morning).schedulables();
    }

    List<Schedulable> afternoon() {
        return sessionMap.get(Session.Type.Afternoon).schedulables();
    }

    Schedulable lunch() {
        return meal;
    }

    Schedulable networking() {
        return networking;
    }

    public List<Schedulable> forScheduling() {
        List<Schedulable> scheduleables = new ArrayList<Schedulable>();
        scheduleables.addAll(morning());
        scheduleables.add(lunch());
        scheduleables.addAll(afternoon());
        scheduleables.add(networking());
        return scheduleables;
    }

    public static class Builder {
        private final Map<Session.Type, Session> sessions2;
        private final Set<Schedulable> available;
        private Meal lunch;
        private Networking networking;

        public Builder(Set<Schedulable> talks) {
            this.available = new HashSet<Schedulable>(talks); // defensive copy
            this.sessions2 = new HashMap<Session.Type, Session>();
        }

        public Builder morning() {
            Session morning = ConferenceSessionFactory.createInstance(Session.Type.Morning,
                    Conference.MORNING_SESSION_DURATION_MINUTES);
            fill(morning);
            sessions2.put(Session.Type.Morning, morning);
            return this;
        }

        public Builder afternoon() {
            Session afternoon = ConferenceSessionFactory.createInstance(Session.Type.Afternoon,
                    Conference.AFTERNOON_SESSION_DURATION_MINUTES);
            fill(afternoon);
            sessions2.put(Session.Type.Afternoon, afternoon);
            return this;
        }

        public Builder lunch() {
            this.lunch = new Meal();
            return this;
        }

        public Builder networking() {
            this.networking = new Networking();
            return this;
        }

        public Track build() {
            return new Track(this);
        }

        private void fill(Session session) {
            for (Schedulable talk : available) {
                try {
                    session.add(talk);
                } catch (IllegalStateException ex) {
                    // todo: log this or change to not have to worry about the exception
                }
            }
            available.removeAll(session.schedulables());
        }
    }


}
