package entity.creature.animal.herbivore.herbivores;

import entity.creature.animal.herbivore.Herbivore;

public class Buffalo extends Herbivore {
    public Buffalo() {
        this.maxWeight = 700;
        this.currentWeight = maxWeight;
        this.needFeedToWellfed = 100;
        this.isAlive = true;
        this.maxSpeed = 3;
    }
}
