package entity;

import entity.creature.animal.Animal;
import entity.creature.animal.herbivore.Herbivore;
import entity.creature.animal.herbivore.Rabbit;
import entity.creature.animal.predator.Predator;
import entity.creature.animal.predator.Wolf;
import entity.creature.plant.Plant;
import util.Settings;
import util.UtilMethods;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Location extends Thread{
    public List<Animal[]> animals = new ArrayList<>();
    Map<String, Integer> countOfAnimals = new HashMap<>();

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
        for (int i = 0; i < UtilMethods.randomChoose(2, wolves.length); i++) {
            wolves[i] = new Wolf();
        }
        for (int i = 0; i < UtilMethods.randomChoose(2, rabbits.length); i++) {
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
        int tempCount = 0;

        for (Animal[] animal : animals) {
            tempCount = tempCount + getAnimals(animal);
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

    public void info () {
        String kindOfAnimal = "";

        for (Animal[] a : animals) {
            int count = 0;
            if(a.getClass().getSimpleName().equals("Wolf[]")){
                kindOfAnimal = "Wolf";
            } else if (a.getClass().getSimpleName().equals("Rabbit[]")) {
                kindOfAnimal = "Rabbit";
            }
            for (Animal animal : a) {
                if(animal != null){
                    count++;
                }
            }
            countOfAnimals.put(kindOfAnimal, count);
        }
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

    public int randomArrayOfAnimals () {
        return UtilMethods.randomChoose(0, animals.size() - 1);
    }

    public void simulationDay () {
        removeDeadAnimals();

        for (Animal[] animal : animals) {
            for (Animal value : animal) {

                if(value != null){
                    int currentArrayForEat = randomArrayOfAnimals();

                    AtomicInteger currentCountOfNotNullAnimalsForEat = new AtomicInteger();

                    Arrays.stream(animals.get(currentArrayForEat)).forEach(animal1 -> {
                        if(animal1 != null){
                            currentCountOfNotNullAnimalsForEat.getAndIncrement();
                        }
                    });

                    organizeArray(animals.get(currentArrayForEat));

                    int currentAnimalForEat = UtilMethods.randomChoose(0, currentCountOfNotNullAnimalsForEat.get() - 1);

                    int currentArrayForReproduce = randomArrayOfAnimals();

                    AtomicInteger currentCountOfNotNullAnimalsForReproduce = new AtomicInteger();

                    Arrays.stream(animals.get(currentArrayForReproduce)).forEach(animal1 -> {
                        if(animal1 != null){
                            currentCountOfNotNullAnimalsForReproduce.getAndIncrement();
                        }
                    });

                    organizeArray(animals.get(currentArrayForReproduce));

                    int currentAnimalForReproduce = UtilMethods.randomChoose(0, currentCountOfNotNullAnimalsForReproduce.get() - 1);

                    if (value instanceof Predator) {
                        value.eat(animals.get(currentArrayForEat)[currentAnimalForEat]);
                    } else if (value instanceof Herbivore) {
                        value.eat(plant);
                    }

                    value.move(Island.locations);
                    value.reproduce(animals.get(currentArrayForReproduce)[currentAnimalForReproduce], animals.get(currentArrayForReproduce));
                    value.die();

                    for (Animal[] animals1 : animals) {
                        organizeArray(animals1);
                    }

                    removeDeadAnimals();
                }
                info();
            }
        }
        plant.growUp();
    }

    @Override
    public void run() {
        simulationDay();
    }
}
