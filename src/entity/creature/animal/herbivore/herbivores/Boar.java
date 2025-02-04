package entity.creature.animal.herbivore.herbivores;

import entity.creature.animal.Animal;
import entity.creature.animal.herbivore.Herbivore;
import util.Settings;

import java.util.HashMap;
import java.util.Map;

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

    }
}
