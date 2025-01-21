package entity.creature.animal.herbivore;

import entity.creature.Creature;
import entity.creature.animal.Animal;
import entity.creature.plant.Plant;

public abstract class Herbivore extends Animal {
    @Override
    public void eat(Creature c) {
        if(isAlive){
            if(c instanceof Plant){
                if(c.currentWeight >= this.needFeedToWellfed &&
                        this.currentWeight + c.currentWeight <= this.maxWeight){
                    this.currentWeight = this.currentWeight + this.needFeedToWellfed;
                    c.currentWeight = c.currentWeight - this.needFeedToWellfed;
                } else if (c.currentWeight < this.needFeedToWellfed &&
                        this.currentWeight + c.currentWeight <= this.maxWeight) {
                    this.currentWeight = this.currentWeight + c.currentWeight;
                    c.currentWeight = 0;
                }
            }else {
                this.decreaseWeight();
            }
        }
    }
}
