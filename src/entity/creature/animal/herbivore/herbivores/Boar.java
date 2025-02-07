package entity.creature.animal.herbivore.herbivores;

import entity.creature.animal.Animal;
import entity.creature.animal.herbivore.Herbivore;
import util.Settings;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Boar extends Herbivore {
    public Map<String, Integer> possibleFood = new HashMap<>();

    public Boar() {
        this.maxWeight = 400;
        this.currentWeight = maxWeight;
        this.needFeedToWellfed = 50;
        this.isAlive = true;
        this.maxSpeed = 2;
        initPossibleFood();
    }

    public void initPossibleFood () {
        this.possibleFood.put(Settings.CATERPILLAR, 90);
        this.possibleFood.put(Settings.MOUSE, 50);
    }

    @Override
    public void eat(Animal animal) {
        int random = ThreadLocalRandom.current().nextInt(0,100);

        for (String s : possibleFood.keySet()) {
            if(animal.getClass().getSimpleName().equals(s) && random <= possibleFood.get(s)){
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
}
