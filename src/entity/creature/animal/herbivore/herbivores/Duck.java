package entity.creature.animal.herbivore.herbivores;

import entity.creature.animal.Animal;
import entity.creature.animal.herbivore.Herbivore;
import util.Settings;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Duck extends Herbivore {
    public Map<String, Integer> possibleFood = new HashMap<>();

    public Duck() {
        this.maxWeight = 1;
        this.currentWeight = maxWeight;
        this.needFeedToWellfed = 0.15;
        this.isAlive = true;
        this.maxSpeed = 4;
        initPossibleFood();
    }

    public void initPossibleFood () {
        this.possibleFood.put(Settings.CATERPILLAR, 90);
    }

    @Override
    public void eat(Animal animal) {
        int random = ThreadLocalRandom.current().nextInt(0,100);

        if (animal instanceof Caterpillar && random <= possibleFood.get(Settings.CATERPILLAR)){
            animal.die(animal);
            if(animal.currentWeight >= this.needFeedToWellfed){
                this.currentWeight = this.currentWeight + this.needFeedToWellfed;
            } else if (animal.currentWeight < this.needFeedToWellfed) {
                this.currentWeight = this.currentWeight + animal.currentWeight;
            }
        } else {
            this.decreaseWeight();
        }
        if(this.currentWeight > this.maxWeight){
            this.currentWeight = this.maxWeight;
        }
    }
}
