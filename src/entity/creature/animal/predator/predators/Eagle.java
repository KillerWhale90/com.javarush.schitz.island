package entity.creature.animal.predator.predators;

import entity.creature.animal.predator.Predator;
import util.Settings;

public class Eagle extends Predator {
    public Eagle() {
        this.maxWeight = 6;
        this.currentWeight = maxWeight;
        this.needFeedToWellfed = 1;
        this.isAlive = true;
        this.maxSpeed = 3;
        initPossibleFood();
    }

    public void initPossibleFood () {
        this.possibleFood.put(Settings.FOX, 10);
        this.possibleFood.put(Settings.RABBIT, 90);
        this.possibleFood.put(Settings.MOUSE, 90);
        this.possibleFood.put(Settings.DUCK, 80);
    }
}
