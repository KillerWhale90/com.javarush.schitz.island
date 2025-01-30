package entity.creature.animal.predator;

import entity.creature.Creature;
import entity.creature.animal.Animal;
import entity.creature.animal.herbivore.Herbivore;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Predator extends Animal {

    Map<Herbivore, Integer> possibleFood = new HashMap<>();

    @Override
    public void eat(Creature c) {
        if (this.isAlive && c != null){
            if(c instanceof Herbivore){
                for (Herbivore herbivore : possibleFood.keySet()) {
                    if(herbivore.getClass().getName().equals(c.getClass().getName()) &&
                            ThreadLocalRandom.current().nextInt(0,100) <= possibleFood.get(herbivore)){
                        herbivore.die();
                        if(herbivore.currentWeight >= this.needFeedToWellfed &&
                                this.currentWeight + this.needFeedToWellfed <= this.maxWeight){
                            this.currentWeight = this.currentWeight + this.needFeedToWellfed;
                        } else if (herbivore.currentWeight < this.needFeedToWellfed &&
                                this.currentWeight + herbivore.currentWeight <= this.maxWeight) {
                            this.currentWeight = this.currentWeight + herbivore.currentWeight;
                        }
                    } else {
                        this.decreaseWeight();
                    }
                }
            }
        }
    }
}