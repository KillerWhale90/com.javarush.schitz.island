package entity.creature.animal.predator;

import entity.creature.animal.herbivore.Rabbit;

public class Wolf extends Predator{

    public Wolf() {
        this.maxWeight = 50;
        this.currentWeight = maxWeight;
        this.needFeedToWellfed = 8;
        this.isAlive = true;
        initPossibleFood();
    }

    public void initPossibleFood () {
        this.possibleFood.put("Rabbit", 60);
    }
}

