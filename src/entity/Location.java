package entity;

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
import java.util.concurrent.atomic.AtomicInteger;

public class Location extends Thread{
    List<Animal[]> animals = new ArrayList<>();

    Plant plant;

    Wolf[] wolves;
    Rabbit[] rabbits;

    public Location() {
        this.wolves = new Wolf[Settings.MAX_COUNT_OF_WOLVES_TO_LOCATION];
        this.rabbits = new Rabbit[Settings.MAX_COUNT_OF_RABBITS_TO_LOCATION];

        this.plant = new Plant(UtilMethods.randomChoose(0, Settings.MAX_COUNT_OF_PLANTS_TO_LOCATION));

        locationInitialisation();
        animals.add(wolves);
        animals.add(rabbits);
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
                if(animal[i] != null && !animal[i].isAlive){
                    animal[i] = null;
                }
            }
        }
    }

    public void countOfAnimalsAndPlants () {
        int tempCount;

        for (Animal[] animal : animals) {
            tempCount = getAnimals(animal);
            System.out.print(animal.getClass().getSimpleName() + " = " + tempCount + " ");
        }
        System.out.println(plant.getClass().getSimpleName() + " = " + getPlants());
    }

    public double getPlants() {
        return plant.currentWeight;
    }

    public int getAnimals(Animal[] a) {
        int count = 0;

        for (Animal animal : a) {
            if (animal != null) {
                count++;
            }
        }

        return count;
    }

    public void organizeArray (Animal[] a) {
        int j = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != null) {
                if(i != j) {
                    Animal temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
                j++;
            }
        }
    }

    public void simulationDay () {
        removeDeadAnimals();

        countOfAnimalsAndPlants();

        for (Animal[] animal : animals) {
            for (Animal value : animal) {

                int currentArrayForEat = UtilMethods.randomChoose(0, animals.size() - 1);

                AtomicInteger currentCountOfNotNullAnimals = new AtomicInteger();

                Arrays.stream(animals.get(currentArrayForEat)).forEach(animal1 -> {
                    if(animal1 != null){
                        currentCountOfNotNullAnimals.getAndIncrement();
                    }
                });

                organizeArray(animals.get(currentArrayForEat));

                int currentAnimalForEat = UtilMethods.randomChoose(0, currentCountOfNotNullAnimals.get() - 1);

                int currentArrayForReproduce = UtilMethods.randomChoose(0, animals.size() - 1);
                int currentAnimalForReproduce = UtilMethods.randomChoose(0, animals.get(currentArrayForReproduce).length - 1);

                if (value != null) {
                    if (value instanceof Predator) {
                        value.eat(animals.get(currentArrayForEat)[currentAnimalForEat]);
                    } else if (value instanceof Herbivore) {
                        value.eat(plant);
                    }

                    value.move();
                    value.reproduce(animals.get(currentArrayForReproduce)[currentAnimalForReproduce], animals.get(currentArrayForReproduce));
                    value.die();
                    removeDeadAnimals();
                }
            }
        }
        System.out.println("-".repeat(100));
        plant.growUp();
    }

    @Override
    public void run() {
        simulationDay();
    }
}
