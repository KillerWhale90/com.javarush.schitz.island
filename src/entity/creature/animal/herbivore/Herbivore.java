package entity.creature.animal.herbivore;

import entity.creature.animal.Animal;
import entity.creature.plant.Plant;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Herbivore extends Animal {
    @Override
    public void eat(Plant plant) {
        int random = ThreadLocalRandom.current().nextInt(0,100);

        if(this.isAlive){
            if(plant != null && random <= 30){
                if(plant.getCurrentWeight() >= this.needFeedToWellfed){
                    this.currentWeight = this.currentWeight + this.needFeedToWellfed;
                    plant.setCurrentWeight(plant.getCurrentWeight() - this.needFeedToWellfed);
                } else if (plant.getCurrentWeight() < this.needFeedToWellfed) {
                    this.currentWeight = this.currentWeight + plant.getCurrentWeight();
                    plant.setCurrentWeight(0);
                }else {
                    this.decreaseWeight();
                }
            }else {
                this.decreaseWeight();
            }
            if(this.currentWeight > this.maxWeight){
                this.currentWeight = this.maxWeight;
            }
        }
    }
}
