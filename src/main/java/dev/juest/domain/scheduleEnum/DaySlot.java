package dev.juest.domain.scheduleEnum;

import java.util.ArrayList;
import java.util.List;

public enum DaySlot {

    LUNES("Lunes",0),
    MARTES("Martes",1),
    MIERCOLES("Miercoles",2),
    JUEVES("Jueves",3),
    VIERNES("Viernes",4);

    private final String day;
    private final int index;

    //-------------------------------------------------------------------------------------------------------------------

    DaySlot(String day, int index) {
        this.day = day;
        this.index = index;
    }

    //-------------------------------------------------------------------------------------------------------------------

    public String getDay() {
        return day;
    }

    //-------------------------------------------------------------------------------------------------------------------

    public int getIndex() {
        return index;
    }

    //-------------------------------------------------------------------------------------------------------------------

    public static List<Integer> fromDayToIndex(List<String> day) {
        List<Integer> index = new ArrayList<>();

        for (String i : day) {
            for(DaySlot slot: DaySlot.values()) {
                if (slot.getDay().equals(i)) {
                    index.add(slot.getIndex());
                }
            }
        }
        return index;
    }
    //-------------------------------------------------------------------------------------------------------------------

}
