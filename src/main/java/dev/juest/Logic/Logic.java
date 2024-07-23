package dev.juest.Logic;

import dev.juest.domain.Lesson;
import dev.juest.domain.Schedule;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Logic {

    List<Schedule> solutions = new ArrayList<>();


    //------------------------------------------------------------------------------------------------------------------

    public List<Schedule> getUniqueSolutions(){
        return removeDuplicates(solutions);
    }

    //------------------------------------------------------------------------------------------------------------------

    private List<Schedule> removeDuplicates(List<Schedule> schedules) {
        Set<Schedule> uniqueSchedules = new HashSet<>(schedules);
        return new ArrayList<>(uniqueSchedules);
    }

    //------------------------------------------------------------------------------------------------------------------

    public void scheduling(Schedule schedule, List<Lesson> lessons) {
        if (schedule.isFull()) {
            solutions.add(new Schedule(schedule));
            return;
        }

        for (int i = 0; i < lessons.size(); i++) {
            Lesson current = lessons.get(i);

            // Verifica si se puede añadir la lección al horario sin colisión y si no ha sido añadida
            if (schedule.checkColision(current) && schedule.checkNotAdded(current)) {
                schedule.add(current); // Añade la lección al horario

                // Realiza la llamada recursiva con el horario actualizado
                this.scheduling(schedule, lessons);

                schedule.remove(current); // Elimina la lección del horario para intentar con la siguiente opción
            }
        }
    }

    //------------------------------------------------------------------------------------------------------------------

}
