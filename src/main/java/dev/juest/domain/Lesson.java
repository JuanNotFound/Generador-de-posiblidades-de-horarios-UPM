package dev.juest.domain;

import java.util.List;

public class Lesson {

    private final String name;
    private final String code;
    private final List<String> days;
    private final List<Integer> startTime;


    //------------------------------------------------------------------------------------------------------------------

    public Lesson(String className, String code, List<String> days, List<Integer> startTime) {
        name = className;
        this.code = code;
        this.days = days;
        this.startTime = startTime;
    }

    //------------------------------------------------------------------------------------------------------------------

    @Override
    public String toString() {
        return name + " " + code + " " + days + " " + startTime;
    }

    //------------------------------------------------------------------------------------------------------------------


    public String getName() {
        return name;
    }

    //------------------------------------------------------------------------------------------------------------------

    public String getCode() {
        return code;
    }

    //------------------------------------------------------------------------------------------------------------------

    public List<String> getDays() {
        return days;
    }

    //------------------------------------------------------------------------------------------------------------------

    public List<Integer> getStartTime() {
        return startTime;
    }

    //------------------------------------------------------------------------------------------------------------------

}
