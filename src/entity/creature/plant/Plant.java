package entity.creature.plant;

import entity.creature.Creature;

public class Plant extends Creature {
    public int currentWeight;
    public final static int maxWeight = 800;

    public Plant(int currentWeight) {
        this.currentWeight = currentWeight;
    }

    public void growUp(){
        if(currentWeight + currentWeight / 20 < maxWeight){
            currentWeight = currentWeight + (currentWeight / 20);
        }
    }
}
