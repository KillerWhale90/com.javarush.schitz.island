package entity.creature.animal.herbivore.herbivores;

import entity.creature.animal.Animal;
import entity.creature.animal.herbivore.Herbivore;
import util.Settings;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Mouse extends Herbivore {
    public Map<String, Integer> possibleFood = new HashMap<>();

    public Mouse() {
        this.maxWeight = 0.05;
        this.currentWeight = maxWeight;
        this.needFeedToWellfed = 0.01;
        this.isAlive = true;
        this.maxSpeed = 1;
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
            if(animal.getCurrentWeight() >= this.needFeedToWellfed){
                this.currentWeight = this.currentWeight + this.needFeedToWellfed;
            } else if (animal.getCurrentWeight() < this.needFeedToWellfed) {
                this.currentWeight = this.currentWeight + animal.getCurrentWeight();
            }
        } else {
            this.decreaseWeight();
        }
        if(this.currentWeight > this.maxWeight){
            this.currentWeight = this.maxWeight;
        }
    }
}
