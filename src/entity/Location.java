package entity;

import entity.creature.Creature;
import entity.creature.animal.Animal;
import entity.creature.animal.herbivore.Herbivore;
import entity.creature.animal.herbivore.Rabbit;
import entity.creature.animal.predator.Predator;
import entity.creature.animal.predator.Wolf;
import entity.creature.plant.Plant;
import util.Settings;
import util.UtilMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Location extends Thread{
    List<Animal[]> animals = new ArrayList<>();

    Plant plant;

    Wolf[] wolves;
    Rabbit[] rabbits;

    public Location() {
        this.wolves = new Wolf[Settings.MAX_COUNT_OF_WOLVES_TO_LOCATION];
        animals.add(wolves);
        this.rabbits = new Rabbit[Settings.MAX_COUNT_OF_RABBITS_TO_LOCATION];
        animals.add(rabbits);
        this.plant = new Plant(UtilMethods.randomChoose(0,Plant.maxWeight));
        locationInitialisation();
    }

    public void locationInitialisation () {
        for (int i = 0; i < UtilMethods.randomChoose(0, wolves.length); i++) {
            wolves[i] = new Wolf();
        }
        for (int i = 0; i < UtilMethods.randomChoose(0, rabbits.length); i++) {
            rabbits[i] = new Rabbit();
        }
    }

    public void removeDeadAnimals () {
        for (Animal[] animal : animals) {
            for (int i = 0; i < animal.length; i++) {
                if(!animal[i].isAlive){
                    animal[i] = null;
                }
            }
        }
    }

    @Override
    public void run() {
        removeDeadAnimals();

        for (Animal[] animal : animals) {
            for (int i = 0; i < animal.length; i++) {
                int currentArrayForEat = UtilMethods.randomChoose(0,animals.size() - 1);
                int currentAnimalForEat = UtilMethods.randomChoose(0,animals.get(currentArrayForEat).length - 1);

                int currentArrayForReproduce = UtilMethods.randomChoose(0,animals.size() - 1);
                int currentAnimalForReproduce = UtilMethods.randomChoose(0,animals.get(currentArrayForEat).length - 1);

                if(animal[i] instanceof Predator){
                    animal[i].eat(animals.get(currentArrayForEat)[currentAnimalForEat]);
                }else if(animal[i] instanceof Herbivore){
                    animal[i].eat(plant);
                }

                animal[i].move();
                animal[i].reproduce(animals.get(currentArrayForReproduce)[currentAnimalForReproduce]);
                animal[i].die();
            }
        }
        plant.growUp();
    }
}
