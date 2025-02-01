package entity;

import entity.creature.animal.Animal;
import entity.creature.animal.predator.Wolf;
import util.Settings;

public class Island extends Thread{

    public static Location[][] locations = new Location[Settings.ROWS_COUNT][Settings.COLUMNS_COUNT];

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

        locations[0][0].animals.getFirst()[0] = new Wolf();
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
        int tempCountOfAnimals = 0;
        double tempCountOfPlants = 0;

        String kindOfAnimals = "";
        String plants = "Plants = ";

        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations.length; j++) {
                for (Animal[] animal : locations[i][j].animals) {
                    tempCountOfAnimals = tempCountOfAnimals + locations[i][j].getAnimals(animal);
                    kindOfAnimals = animal.getClass().getSimpleName();
                }
                tempCountOfPlants = tempCountOfPlants + locations[i][j].getPlants();
            }
        }

        System.out.print(kindOfAnimals + " = " + tempCountOfAnimals + " ");
        System.out.println(plants + tempCountOfPlants);
    }

    @Override
    public void run() {
        while (Settings.SIMULATION_DAYS > 0){
            System.out.println("Simulation day's rest: " + Settings.SIMULATION_DAYS);
            countOfAnimalsAndPlants();
            for (int i = 0; i < locations.length; i++) {
                for (int j = 0; j < locations.length; j++) {
                    locations[i][j].simulationDay();
                }
            }
            Settings.SIMULATION_DAYS--;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
