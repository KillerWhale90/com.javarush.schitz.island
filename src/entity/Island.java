package entity;

import entity.creature.animal.Animal;
import util.Settings;

public class Island extends Thread{
    private static int columnsCount;

    private static int rowsCount;

    public Island(int rowsCount, int columnsCount) {
        Island.columnsCount = columnsCount;
        Island.rowsCount = rowsCount;
    }

    public static Location[][] locations = new Location[rowsCount][columnsCount];

    @Override
    public void run() {
        while (Settings.SIMULATION_DAYS > 0){
            for (int i = 0; i < locations.length; i++) {
                for (int j = 0; j < locations.length; j++) {
                    locations[i][j].start();
                    for (Animal[] animal : locations[i][j].animals) {
                        for (int k = 0; k < animal.length; k++) {
                            animal[k].y = i;
                            animal[k].x = j;
                        }
                    }
                }
            }
            Settings.SIMULATION_DAYS--;
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
