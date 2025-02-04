package entity.creature.animal.predator.predators;

import entity.creature.animal.predator.Predator;
import util.Settings;

public class Bear extends Predator {
    public Bear() {
        this.maxWeight = 500;
        this.currentWeight = maxWeight;
        this.needFeedToWellfed = 80;
        this.isAlive = true;
        this.maxSpeed = 2;
        initPossibleFood();
    }

    public void initPossibleFood () {
        this.possibleFood.put(Settings.SNAKE, 80);
        this.possibleFood.put(Settings.HORSE, 40);
        this.possibleFood.put(Settings.DEER, 80);
        this.possibleFood.put(Settings.RABBIT, 80);
        this.possibleFood.put(Settings.MOUSE, 90);
        this.possibleFood.put(Settings.FOX, 15);
        this.possibleFood.put(Settings.GOAT, 70);
        this.possibleFood.put(Settings.SHEEP, 70);
        this.possibleFood.put(Settings.BOAR, 50);
        this.possibleFood.put(Settings.DUCK, 10);
    }
}
