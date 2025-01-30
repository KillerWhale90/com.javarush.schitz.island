package entity;

import entity.creature.animal.Animal;
import util.Settings;

public class Island extends Thread{

    public static Location[][] locations = new Location[Settings.ROWS_COUNT][Settings.COLUMNS_COUNT];

    public Island() {
        initLocations();
    }

    public void initLocations () {
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations.length; j++) {
                locations[i][j] = new Location();
            }
        }
    }

    @Override
    public void run() {
        while (Settings.SIMULATION_DAYS > 0){
            System.out.println("Simulation day's rest: " + Settings.SIMULATION_DAYS);
            for (int i = 0; i < locations.length; i++) {
                for (int j = 0; j < locations.length; j++) {
                    for (Animal[] animal : locations[i][j].animals) {
                        for (int k = 0; k < animal.length; k++) {
                            if(animal[k] != null){
                                animal[k].y = i;
                                animal[k].x = j;
                            }
                        }
                    }
                    locations[i][j].simulationDay();
                }
            }
            Settings.SIMULATION_DAYS--;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
