package entity.creature.animal.predator.predators;

import entity.creature.animal.predator.Predator;
import util.Settings;

public class Snake extends Predator {
    public Snake() {
        this.maxWeight = 15;
        this.currentWeight = maxWeight;
        this.needFeedToWellfed = 3;
        this.isAlive = true;
        this.maxSpeed = 1;
        initPossibleFood();
    }

    public void initPossibleFood () {
        this.possibleFood.put(Settings.RABBIT, 20);
        this.possibleFood.put(Settings.FOX, 15);
        this.possibleFood.put(Settings.MOUSE, 40);
        this.possibleFood.put(Settings.DUCK, 10);
    }
}
