package entity.creature.animal.herbivore.herbivores;

import entity.creature.animal.herbivore.Herbivore;

public class Horse extends Herbivore {
    public Horse() {
        this.maxWeight = 400;
        this.currentWeight = maxWeight;
        this.needFeedToWellfed = 60;
        this.isAlive = true;
        this.maxSpeed = 4;
    }
}
