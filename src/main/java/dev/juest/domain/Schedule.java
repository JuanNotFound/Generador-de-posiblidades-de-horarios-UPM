package dev.juest.domain;

import dev.juest.domain.scheduleEnum.DaySlot;
import dev.juest.domain.scheduleEnum.TimeSlot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Schedule {

    private final Lesson[][] schedule;
    private List<String> addedClasses = new ArrayList<String>();
    private Integer lessonsNeeded;

    //-------------------------------------------------------------------------------------------------------------------

    public Schedule(Integer lessonsNeeded) {
        this.schedule = new Lesson[6][5];
        this.lessonsNeeded = lessonsNeeded;
    }

    public Schedule(Schedule other) {
        this.schedule = new Lesson[6][5];
        for (int i = 0; i < 6; i++) {
            System.arraycopy(other.schedule[i], 0, this.schedule[i], 0, 5);
        }
        this.addedClasses = new ArrayList<>(other.addedClasses);
    }

    //-------------------------------------------------------------------------------------------------------------------

    public void add(Lesson paramLesson) {

        List<Integer> timeIndex = TimeSlot.fromTimeToIndex(paramLesson.getStartTime());
        List<Integer> dayIndex = DaySlot.fromDayToIndex(paramLesson.getDays());

        for (int day = 0, hour = 0; hour < timeIndex.size() && day < dayIndex.size() ; day++, hour++){
            schedule[timeIndex.get(hour)][dayIndex.get(day)] = paramLesson;
            addedClasses.add(paramLesson.getName());
        }
    }


    //-------------------------------------------------------------------------------------------------------------------

    public void remove(Lesson paramLesson) {

        List<Integer> timeIndex = TimeSlot.fromTimeToIndex(paramLesson.getStartTime());
        List<Integer> dayIndex = DaySlot.fromDayToIndex(paramLesson.getDays());

        for (int day = 0, hour = 0; hour < timeIndex.size() && day < dayIndex.size() ; day++, hour++){
            schedule[timeIndex.get(hour)][dayIndex.get(day)] = null;
            addedClasses.remove(paramLesson.getName());
        }
    }

    //-------------------------------------------------------------------------------------------------------------------


    public boolean checkColision(Lesson paramLesson) {
        List<Integer> timeIndex = TimeSlot.fromTimeToIndex(paramLesson.getStartTime());
        List<Integer> dayIndex = DaySlot.fromDayToIndex(paramLesson.getDays());

        for (int day = 0, hour = 0; hour < timeIndex.size() && day < dayIndex.size() ; day++, hour++){
            if(schedule[timeIndex.get(hour)][dayIndex.get(day)] != null){
                return false;
            }
        }
        return true;
    }


    //-------------------------------------------------------------------------------------------------------------------


    public boolean checkNotAdded(Lesson lesson) {
        return !addedClasses.contains(lesson.getName());
    }


    //-------------------------------------------------------------------------------------------------------------------

    public boolean isFull() {
        return addedClasses.size() == lessonsNeeded;

    }

    //-------------------------------------------------------------------------------------------------------------------

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule1 = (Schedule) o;
        return Arrays.deepEquals(schedule, schedule1.schedule);
    }

    //-------------------------------------------------------------------------------------------------------------------

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(schedule);
    }

    //-------------------------------------------------------------------------------------------------------------------

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("----HORAS----    LUN    MAR    MIE    JUE    VIE \n");
        int startTime = 9;
        sb.append("0");

        for (Lesson[] lessons : schedule) {
            int endTime = startTime + 2;
            sb.append(startTime).append(":00 - ").append(endTime).append(":00    ");

            for (int j = 0; j < schedule[0].length; j++) {

                if (lessons[j] != null) {

                    sb.append(lessons[j].getName());
                    sb.append("    ");
                } else {
                    sb.append("---");
                    sb.append("    ");

                }

            }

            startTime = endTime;
            sb.append("\n");
        }


        return sb.toString();
    }

    //-------------------------------------------------------------------------------------------------------------------



}
