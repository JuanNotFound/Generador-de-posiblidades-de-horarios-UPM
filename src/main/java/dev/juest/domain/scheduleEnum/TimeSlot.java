package dev.juest.domain.scheduleEnum;


import java.util.ArrayList;
import java.util.List;

public enum TimeSlot {

        SLOT_1(9,0),
        SLOT_2(11,1),
        SLOT_3(13,2),
        SLOT_4(15,3),
        SLOT_5(17,4),
        SLOT_6(19,5 );

        private final int hour;
        private final int index;

    //-------------------------------------------------------------------------------------------------------------------

    TimeSlot(int hour, int index) {
            this.hour = hour;
            this.index = index;
        }
    //-------------------------------------------------------------------------------------------------------------------

        public int getHour() {
            return hour;
        }

    //-------------------------------------------------------------------------------------------------------------------

    public int getIndex() {
            return index;
        }

    //-------------------------------------------------------------------------------------------------------------------


    public static List<Integer> fromTimeToIndex(List<Integer> hour) {
            List<Integer> result = new ArrayList<>();

            for (Integer i : hour) {
               for(TimeSlot slot: TimeSlot.values()) {
                   if (slot.getHour() == i) {
                       result.add(slot.getIndex());
                   }
               }
            }
            return result;
        }
    //-------------------------------------------------------------------------------------------------------------------

}



