package lesson_1;

public class Main {

    public static void main(String[] args) {
        final int NUMBERS_OBSTACLES = 5;
        final int NUMBERS_PARTICIPANT = 3;

        Participant [] array_participants = new Participant[NUMBERS_PARTICIPANT];
        array_participants[0] = (Participant) new Man("Tom", true);
        array_participants[1] = (Participant) new Cat("kitty", true);
        array_participants[2] = (Participant) new Robot("T-404", true);

        Obstacle [] array_obstacles = new Obstacle[NUMBERS_OBSTACLES];
        array_obstacles[0] = (Obstacle) new Obstacle("track", 20);;
        array_obstacles[1] = (Obstacle) new Obstacle("wall", 1);
        array_obstacles[2] = (Obstacle) new Obstacle("track", 200);
        array_obstacles[3] = (Obstacle) new Obstacle("wall", 2);
        array_obstacles[4] = (Obstacle) new Obstacle("track", 2000);

        new Game(array_participants, array_obstacles, NUMBERS_OBSTACLES);
    }
}
