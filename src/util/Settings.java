package util;

import entity.creature.animal.herbivore.herbivores.*;
import entity.creature.animal.predator.predators.*;

public class Settings {
    public final static int COLUMNS_COUNT = 3;

    public final static int ROWS_COUNT = 3;

    public static int SIMULATION_DAYS = 100;

    //MAX COUNT OF ANIMAL
    public final static int MAX_COUNT_OF_PLANTS_TO_LOCATION = 800;
    public final static int MAX_COUNT_OF_WOLVES_TO_LOCATION = 30;
    public final static int MAX_COUNT_OF_RABBITS_TO_LOCATION = 150;
    public final static int MAX_COUNT_OF_SNAKES_TO_LOCATION = 30;
    public final static int MAX_COUNT_OF_FOXES_TO_LOCATION = 30;
    public final static int MAX_COUNT_OF_BEARS_TO_LOCATION = 5;
    public final static int MAX_COUNT_OF_EAGLES_TO_LOCATION = 20;
    public final static int MAX_COUNT_OF_HORSES_TO_LOCATION = 20;
    public final static int MAX_COUNT_OF_DEERS_TO_LOCATION = 20;
    public final static int MAX_COUNT_OF_MOUSES_TO_LOCATION = 500;
    public final static int MAX_COUNT_OF_GOATS_TO_LOCATION = 140;
    public final static int MAX_COUNT_OF_SHEEPS_TO_LOCATION = 140;
    public final static int MAX_COUNT_OF_BOARS_TO_LOCATION = 50;
    public final static int MAX_COUNT_OF_DUCKS_TO_LOCATION = 200;
    public final static int MAX_COUNT_OF_BUFFALOS_TO_LOCATION = 10;
    public final static int MAX_COUNT_OF_CATERPILLARS_TO_LOCATION = 1000;


    //NAME'S OF ANIMAL
    public static String WOLF = Wolf.class.getSimpleName();
    public static String RABBIT = Rabbit.class.getSimpleName();
    public static String SNAKE = Snake.class.getSimpleName();
    public static String FOX = Fox.class.getSimpleName();
    public static String BEAR = Bear.class.getSimpleName();
    public static String EAGLE = Eagle.class.getSimpleName();
    public static String BOAR = Boar.class.getSimpleName();
    public static String BUFFALO = Buffalo.class.getSimpleName();
    public static String CATERPILLAR = Caterpillar.class.getSimpleName();
    public static String DEER = Deer.class.getSimpleName();
    public static String DUCK = Duck.class.getSimpleName();
    public static String GOAT = Goat.class.getSimpleName();
    public static String HORSE = Horse.class.getSimpleName();
    public static String MOUSE = Mouse.class.getSimpleName();
    public static String SHEEP = Sheep.class.getSimpleName();
}
