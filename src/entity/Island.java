package entity;

import entity.creature.animal.Animal;
import util.Settings;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Island extends Thread{

    public static Location[][] locations = new Location[Settings.ROWS_COUNT][Settings.COLUMNS_COUNT];

    Map<String, Integer> generalCountOfAnimals = new HashMap<>();

    ExecutorService executorService = Executors.newFixedThreadPool(Settings.ROWS_COUNT*Settings.COLUMNS_COUNT);

    public Island() {
        initLocations();
        initCoordinate();
    }

    @Override
    public void run() {
        while (Settings.SIMULATION_DAYS > 0){
            System.out.println("Simulation day's rest: " + Settings.SIMULATION_DAYS);
            for (int i = 0; i < locations.length; i++) {
                for (int j = 0; j < locations[i].length; j++) {
                    executorService.execute(locations[i][j]);
                }
            }
            countOfAnimalsAndPlants();
            Settings.SIMULATION_DAYS--;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        executorService.shutdown();
    }

    public void initLocations () {
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                locations[i][j] = new Location();
            }
        }
    }

    public void initCoordinate () {
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                for (Animal[] animal : locations[i][j].animals) {
                    for (Animal value : animal) {
                        if (value != null) {
                            value.setYcoordinate(i);
                            value.setXcoordinate(j);
                        }
                    }
                }
            }
        }
    }

    public void countOfAnimalsAndPlants () {
        int generalCountOfWolf = 0;
        int generalCountOfSnakes = 0;
        int generalCountOfFoxes = 0;
        int generalCountOfEagles = 0;
        int generalCountOfBears = 0;

        int generalCountOfRabbit = 0;
        int generalCountOfSheep = 0;
        int generalCountOfMouses = 0;
        int generalCountOfHorses = 0;
        int generalCountOfGoats = 0;
        int generalCountOfDucks = 0;
        int generalCountOfDeer = 0;
        int generalCountOfCaterpillar = 0;
        int generalCountOfBuffalo = 0;
        int generalCountOfBoars = 0;

        double generalCountOfPlants = 0;

        String plants = "Plants = ";

        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                for (String key : locations[i][j].countOfAnimals.keySet()) {
                    if(key.equals(Settings.WOLF)){
                        generalCountOfWolf = generalCountOfWolf + locations[i][j].countOfAnimals.get(key);
                    } else if (key.equals(Settings.SNAKE)) {
                        generalCountOfSnakes = generalCountOfSnakes + locations[i][j].countOfAnimals.get(key);
                    } else if (key.equals(Settings.FOX)) {
                        generalCountOfFoxes = generalCountOfFoxes + locations[i][j].countOfAnimals.get(key);
                    } else if (key.equals(Settings.EAGLE)) {
                        generalCountOfEagles = generalCountOfEagles + locations[i][j].countOfAnimals.get(key);
                    } else if (key.equals(Settings.BEAR)) {
                        generalCountOfBears = generalCountOfBears + locations[i][j].countOfAnimals.get(key);
                    } else if (key.equals(Settings.RABBIT)) {
                        generalCountOfRabbit = generalCountOfRabbit + locations[i][j].countOfAnimals.get(key);
                    } else if (key.equals(Settings.SHEEP)) {
                        generalCountOfSheep = generalCountOfSheep + locations[i][j].countOfAnimals.get(key);
                    } else if (key.equals(Settings.MOUSE)) {
                        generalCountOfMouses = generalCountOfMouses + locations[i][j].countOfAnimals.get(key);
                    } else if (key.equals(Settings.HORSE)) {
                        generalCountOfHorses = generalCountOfHorses + locations[i][j].countOfAnimals.get(key);
                    } else if (key.equals(Settings.GOAT)) {
                        generalCountOfGoats = generalCountOfGoats + locations[i][j].countOfAnimals.get(key);
                    } else if (key.equals(Settings.DUCK)) {
                        generalCountOfDucks = generalCountOfDucks + locations[i][j].countOfAnimals.get(key);
                    } else if (key.equals(Settings.DEER)) {
                        generalCountOfDeer = generalCountOfDeer + locations[i][j].countOfAnimals.get(key);
                    } else if (key.equals(Settings.CATERPILLAR)) {
                        generalCountOfCaterpillar = generalCountOfCaterpillar + locations[i][j].countOfAnimals.get(key);
                    } else if (key.equals(Settings.BUFFALO)) {
                        generalCountOfBuffalo = generalCountOfBuffalo + locations[i][j].countOfAnimals.get(key);
                    } else if (key.equals(Settings.BOAR)) {
                        generalCountOfBoars = generalCountOfBoars + locations[i][j].countOfAnimals.get(key);
                    }
                }
                generalCountOfPlants = generalCountOfPlants + locations[i][j].getPlants();
            }
        }

        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                for (String key : locations[i][j].countOfAnimals.keySet()) {
                    if(key.equals(Settings.WOLF)){
                        generalCountOfAnimals.put(key, generalCountOfWolf);
                    } else if (key.equals(Settings.SNAKE)) {
                        generalCountOfAnimals.put(key, generalCountOfSnakes);
                    } else if (key.equals(Settings.FOX)) {
                        generalCountOfAnimals.put(key, generalCountOfFoxes);
                    } else if (key.equals(Settings.EAGLE)) {
                        generalCountOfAnimals.put(key, generalCountOfEagles);
                    } else if (key.equals(Settings.BEAR)) {
                        generalCountOfAnimals.put(key, generalCountOfBears);
                    } else if (key.equals(Settings.RABBIT)) {
                        generalCountOfAnimals.put(key, generalCountOfRabbit);
                    } else if (key.equals(Settings.SHEEP)) {
                        generalCountOfAnimals.put(key, generalCountOfSheep);
                    } else if (key.equals(Settings.MOUSE)) {
                        generalCountOfAnimals.put(key, generalCountOfMouses);
                    } else if (key.equals(Settings.HORSE)) {
                        generalCountOfAnimals.put(key, generalCountOfHorses);
                    } else if (key.equals(Settings.GOAT)) {
                        generalCountOfAnimals.put(key, generalCountOfGoats);
                    } else if (key.equals(Settings.DUCK)) {
                        generalCountOfAnimals.put(key, generalCountOfDucks);
                    } else if (key.equals(Settings.DEER)) {
                        generalCountOfAnimals.put(key, generalCountOfDeer);
                    } else if (key.equals(Settings.CATERPILLAR)) {
                        generalCountOfAnimals.put(key, generalCountOfCaterpillar);
                    } else if (key.equals(Settings.BUFFALO)) {
                        generalCountOfAnimals.put(key, generalCountOfBuffalo);
                    } else if (key.equals(Settings.BOAR)) {
                        generalCountOfAnimals.put(key, generalCountOfBoars);
                    }
                }
            }
        }
        System.out.println(generalCountOfAnimals);
        System.out.println(plants + generalCountOfPlants);
        System.out.println("-".repeat(160));
    }
}
