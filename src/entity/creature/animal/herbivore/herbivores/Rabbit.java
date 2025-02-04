package entity.creature.animal.herbivore.herbivores;

import entity.creature.animal.herbivore.Herbivore;

public class Rabbit extends Herbivore {
    public Rabbit () {
        this.maxWeight = 2;
        this.currentWeight = maxWeight;
        this.needFeedToWellfed = 0.45;
        this.maxSpeed = 2;
        this.isAlive = true;
    }
}
