package lesson_1;

import java.util.Arrays;

public class Game {
    public Game(Participant[] array_participants, Obstacle[] array_obstacles, int NUMBERS_OBSTACLES) {
        boolean finGame = false;
        System.out.println("Игра началась");
        int i = 0;
        while (i < NUMBERS_OBSTACLES){
            for (Obstacle obstacle : array_obstacles) {
                obstacle.print_info();
                //obstacle.tip.toString();
                for (Participant participant : array_participants) {
                    participant.participant();
                    if (obstacle.tip == "track"){
                        int measure = (int) obstacle.measure;
                        participant.run(measure);
                    }
                    if (obstacle.tip == "wall"){
                        int measure = (int) obstacle.measure;
                        participant.jump(measure);
                    }
                }
                i++;
            }



        }
    }
}
