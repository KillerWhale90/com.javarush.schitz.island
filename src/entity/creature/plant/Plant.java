package entity.creature.plant;

import entity.creature.Creature;

public class Plant extends Creature {

    public Plant(int currentWeight) {
        this.maxWeight = 800;
        this.currentWeight = currentWeight;
    }

    public void growUp(){
        if(currentWeight < maxWeight){
            currentWeight = currentWeight + (currentWeight / 30);
        }
        if(currentWeight > maxWeight){
            currentWeight = maxWeight;
        }
    }
}
