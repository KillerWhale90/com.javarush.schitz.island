package entity.creature.animal.herbivore.herbivores;

import entity.creature.animal.herbivore.Herbivore;

public class Deer extends Herbivore {
    public Deer() {
        this.maxWeight = 300;
        this.currentWeight = maxWeight;
        this.needFeedToWellfed = 50;
        this.isAlive = true;
        this.maxSpeed = 4;
    }
}
