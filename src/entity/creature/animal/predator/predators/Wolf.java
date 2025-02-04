package entity.creature.animal.predator.predators;

import entity.creature.animal.predator.Predator;
import util.Settings;

public class Wolf extends Predator {

    public Wolf() {
        this.maxWeight = 50;
        this.currentWeight = maxWeight;
        this.needFeedToWellfed = 8;
        this.isAlive = true;
        this.maxSpeed = 3;
        initPossibleFood();
    }

    public void initPossibleFood () {
        this.possibleFood.put(Settings.RABBIT, 60);
        this.possibleFood.put(Settings.HORSE, 10);
        this.possibleFood.put(Settings.DEER, 15);
        this.possibleFood.put(Settings.MOUSE, 80);
        this.possibleFood.put(Settings.GOAT, 60);
        this.possibleFood.put(Settings.SHEEP, 70);
        this.possibleFood.put(Settings.BOAR, 15);
        this.possibleFood.put(Settings.BUFFALO, 10);
        this.possibleFood.put(Settings.DUCK, 40);
    }
}

