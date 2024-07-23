package dev.juest;

import dev.juest.Logic.Logic;
import dev.juest.domain.Lesson;
import dev.juest.domain.Schedule;
import dev.juest.Logic.read.JsonManager;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        JsonManager manager = new JsonManager();
        List<Lesson> horarios = manager.parseJSON("horarios.json");
        horarios.forEach(System.out::println);
        Logic logic = new Logic();
        logic.scheduling(new Schedule(13),horarios);

        List<Schedule> list = logic.getUniqueSolutions();

        for (Schedule schedule : list) {
            System.out.println(schedule);
        }
    }

}
