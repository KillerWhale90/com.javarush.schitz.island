package entity.creature.animal.herbivore.herbivores;

import entity.creature.animal.herbivore.Herbivore;

public class Sheep extends Herbivore {
    public Sheep() {
        this.maxWeight = 70;
        this.currentWeight = maxWeight;
        this.needFeedToWellfed = 15;
        this.isAlive = true;
        this.maxSpeed = 3;
    }
}
