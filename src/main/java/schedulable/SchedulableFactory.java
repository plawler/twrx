package schedulable;

import schedulable.Schedulable;
import schedulable.Talk;

public class SchedulableFactory {

    public static Schedulable createTalk(String talk) {
        boolean lightning = false;
        if (parseTime(talk).equals("lightning")) {
            lightning = true;
        }
        return new Talk(name(talk), Integer.parseInt(duration(talk)), lightning);
    }

    static String duration(String rawTalk) {
        String minutes = parseTime(rawTalk);
        if (minutes.equals("lightning")) return "5";
        return minutes.replaceAll("min", "");
    }

    static String name(String rawTalk) {
        return rawTalk.replaceAll(parseTime(rawTalk), "").trim();
    }

    static String parseTime(String rawTalk) {
        String[] chunks = rawTalk.split(" ");
        return chunks[chunks.length - 1];
    }
}
