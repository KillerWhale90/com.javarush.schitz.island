package entity.creature.plant;

import entity.creature.Creature;

import java.util.concurrent.ThreadLocalRandom;

public class Plant extends Creature {

    public Plant(int currentWeight) {
        this.maxWeight = 800;
        this.currentWeight = currentWeight;
    }

    public void growUp(){
        int random = ThreadLocalRandom.current().nextInt(0,100);
        if(currentWeight < maxWeight){
            currentWeight = currentWeight + (currentWeight / 20);
        }
        if(currentWeight > maxWeight){
            currentWeight = maxWeight;
        }
        if(currentWeight == 0){
            currentWeight = currentWeight + random;
        }
    }

    public double getCurrentWeight () {
        return this.currentWeight;
    }

    public void setCurrentWeight (double currentWeight) {
        this.currentWeight = currentWeight;
    }
}
