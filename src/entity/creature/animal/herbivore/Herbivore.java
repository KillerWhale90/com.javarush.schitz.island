package entity.creature.animal.herbivore;

import entity.creature.animal.Animal;
import entity.creature.plant.Plant;

public abstract class Herbivore extends Animal {
    @Override
    public void eat(Plant plant) {
        if(this.isAlive){
            if(plant != null){
                if(plant.currentWeight >= this.needFeedToWellfed){
                    this.currentWeight = this.currentWeight + this.needFeedToWellfed;
                    plant.currentWeight = plant.currentWeight - this.needFeedToWellfed;
                } else if (plant.currentWeight < this.needFeedToWellfed) {
                    this.currentWeight = this.currentWeight + plant.currentWeight;
                    plant.currentWeight = 0;
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
