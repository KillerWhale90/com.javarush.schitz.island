package entity;

import entity.creature.animal.Animal;
import util.Settings;

import java.util.HashMap;
import java.util.Map;

public class Island extends Thread{

    public static Location[][] locations = new Location[Settings.ROWS_COUNT][Settings.COLUMNS_COUNT];
    Map<String, Integer> generalCountOfAnimals = new HashMap<>();

    public Island() {
        initLocations();
        initCoordinate();
    }

    public void initLocations () {
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations.length; j++) {
                locations[i][j] = new Location();
            }
        }
    }

    public void initCoordinate () {
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations.length; j++) {
                for (Animal[] animal : locations[i][j].animals) {
                    for (Animal value : animal) {
                        if (value != null) {
                            value.y = i;
                            value.x = j;
                        }
                    }
                }
            }
        }
    }

    public void countOfAnimalsAndPlants () {
        int generalCountOfWolf = 0;
        int generalCountOfRabbit = 0;

        double generalCountOfPlants = 0;

        String plants = "Plants = ";

        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations.length; j++) {
                for (String key : locations[i][j].countOfAnimals.keySet()) {
                    if(key.equals(Settings.WOLF)){
                        generalCountOfWolf = generalCountOfWolf + locations[i][j].countOfAnimals.get(key);
                    } else if (key.equals(Settings.RABBIT)) {
                        generalCountOfRabbit = generalCountOfRabbit + locations[i][j].countOfAnimals.get(key);
                    }
                }
                generalCountOfPlants = generalCountOfPlants + locations[i][j].getPlants();
            }
        }

        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations.length; j++) {
                for (String key : locations[i][j].countOfAnimals.keySet()) {
                    if(key.equals(Settings.WOLF)){
                        generalCountOfAnimals.put(key, generalCountOfWolf);
                    } else if (key.equals(Settings.RABBIT)) {
                        generalCountOfAnimals.put(key, generalCountOfRabbit);
                    }
                }
            }
        }
        System.out.println(generalCountOfAnimals);

        System.out.println(plants + generalCountOfPlants);
    }



    @Override
    public void run() {
        while (Settings.SIMULATION_DAYS > 0){
            System.out.println("Simulation day's rest: " + Settings.SIMULATION_DAYS);
            for (int i = 0; i < locations.length; i++) {
                for (int j = 0; j < locations.length; j++) {
                    locations[i][j].simulationDay();
                }
            }
            countOfAnimalsAndPlants();
            Settings.SIMULATION_DAYS--;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
