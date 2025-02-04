package entity.creature.animal.herbivore.herbivores;

import entity.creature.animal.herbivore.Herbivore;

public class Goat extends Herbivore {
    public Goat() {
        this.maxWeight = 60;
        this.currentWeight = maxWeight;
        this.needFeedToWellfed = 10;
        this.isAlive = true;
        this.maxSpeed = 3;
    }
}
