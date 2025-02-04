package entity.creature.animal.herbivore.herbivores;

import entity.creature.animal.herbivore.Herbivore;

public class Caterpillar extends Herbivore {
    public Caterpillar() {
        this.maxWeight = 0.01;
        this.currentWeight = maxWeight;
        this.needFeedToWellfed = 0;
        this.isAlive = true;
        this.maxSpeed = 0;
    }
}
