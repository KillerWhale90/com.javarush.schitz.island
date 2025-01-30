package entity.creature.animal.predator;

import entity.creature.Creature;
import entity.creature.animal.Animal;
import entity.creature.animal.herbivore.Herbivore;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Predator extends Animal {

    Map<String, Integer> possibleFood = new HashMap<>();

    @Override
    public void eat(Animal animal) {
        int random = ThreadLocalRandom.current().nextInt(0,100);

        if (this.isAlive && animal != null){
            if(animal instanceof Herbivore){
                for (String herbivore : possibleFood.keySet()) {
                    if(herbivore.equals(animal.getClass().getSimpleName()) &&
                            random <= possibleFood.get(herbivore)){
                        animal.die(animal);
                        if(animal.currentWeight >= this.needFeedToWellfed &&
                                this.currentWeight + this.needFeedToWellfed <= this.maxWeight){
                            this.currentWeight = this.currentWeight + this.needFeedToWellfed;
                        } else if (animal.currentWeight < this.needFeedToWellfed &&
                                this.currentWeight + animal.currentWeight <= this.maxWeight) {
                            this.currentWeight = this.currentWeight + animal.currentWeight;
                        }
                    } else {
                        this.decreaseWeight();
                    }
                }
            }
        }else {
            this.decreaseWeight();
        }
    }
}