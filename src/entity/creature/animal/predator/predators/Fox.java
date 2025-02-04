package entity.creature.animal.predator.predators;

import entity.creature.animal.predator.Predator;
import util.Settings;

public class Fox extends Predator {
    public Fox() {
        this.maxWeight = 8;
        this.currentWeight = maxWeight;
        this.needFeedToWellfed = 2;
        this.isAlive = true;
        this.maxSpeed = 2;
        initPossibleFood();
    }

    public void initPossibleFood () {
        this.possibleFood.put(Settings.RABBIT, 70);
        this.possibleFood.put(Settings.CATERPILLAR, 40);
        this.possibleFood.put(Settings.MOUSE, 90);
        this.possibleFood.put(Settings.DUCK, 60);
    }
}
