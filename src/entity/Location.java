package entity;

import entity.creature.animal.Animal;
import entity.creature.animal.herbivore.Herbivore;
import entity.creature.animal.herbivore.herbivores.*;
import entity.creature.animal.predator.Predator;
import entity.creature.animal.predator.predators.*;
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
    Snake[] snakes;
    Fox[] foxes;
    Bear[] bears;
    Eagle[] eagles;

    Rabbit[] rabbits;
    Boar[] boars;
    Buffalo[] buffalo;
    Caterpillar[] caterpillars;
    Deer[] deer;
    Duck[] ducks;
    Goat[] goats;
    Horse[] horses;
    Sheep[] sheep;
    Mouse[] mice;

    public Location() {
        this.wolves = new Wolf[Settings.MAX_COUNT_OF_WOLVES_TO_LOCATION];
        this.snakes = new Snake[Settings.MAX_COUNT_OF_SNAKES_TO_LOCATION];
        this.foxes = new Fox[Settings.MAX_COUNT_OF_FOXES_TO_LOCATION];
        this.bears = new Bear[Settings.MAX_COUNT_OF_BEARS_TO_LOCATION];
        this.eagles = new Eagle[Settings.MAX_COUNT_OF_EAGLES_TO_LOCATION];

        this.rabbits = new Rabbit[Settings.MAX_COUNT_OF_RABBITS_TO_LOCATION];
        this.boars = new Boar[Settings.MAX_COUNT_OF_BOARS_TO_LOCATION];
        this.buffalo = new Buffalo[Settings.MAX_COUNT_OF_BUFFALOS_TO_LOCATION];
        this.caterpillars = new Caterpillar[Settings.MAX_COUNT_OF_CATERPILLARS_TO_LOCATION];
        this.deer = new Deer[Settings.MAX_COUNT_OF_DEERS_TO_LOCATION];
        this.ducks = new Duck[Settings.MAX_COUNT_OF_DUCKS_TO_LOCATION];
        this.goats = new Goat[Settings.MAX_COUNT_OF_GOATS_TO_LOCATION];
        this.horses = new Horse[Settings.MAX_COUNT_OF_HORSES_TO_LOCATION];
        this.sheep = new Sheep[Settings.MAX_COUNT_OF_SHEEPS_TO_LOCATION];
        this.mice = new Mouse[Settings.MAX_COUNT_OF_MOUSES_TO_LOCATION];

        this.plant = new Plant(UtilMethods.randomChoose(0, Settings.MAX_COUNT_OF_PLANTS_TO_LOCATION));

        locationInitialisation();

        animals.add(wolves);
        animals.add(snakes);
        animals.add(foxes);
        animals.add(bears);
        animals.add(eagles);

        animals.add(rabbits);
        animals.add(boars);
        animals.add(buffalo);
        animals.add(caterpillars);
        animals.add(deer);
        animals.add(ducks);
        animals.add(goats);
        animals.add(horses);
        animals.add(sheep);
        animals.add(mice);
    }

    public void locationInitialisation () {
        for (int i = 0; i < UtilMethods.randomChoose(2, wolves.length); i++) {
            wolves[i] = new Wolf();
        }
        for (int i = 0; i < UtilMethods.randomChoose(2, snakes.length); i++) {
            snakes[i] = new Snake();
        }
        for (int i = 0; i < UtilMethods.randomChoose(2, foxes.length); i++) {
            foxes[i] = new Fox();
        }
        for (int i = 0; i < UtilMethods.randomChoose(2, eagles.length); i++) {
            eagles[i] = new Eagle();
        }
        for (int i = 0; i < UtilMethods.randomChoose(2, bears.length); i++) {
            bears[i] = new Bear();
        }

        for (int i = 0; i < UtilMethods.randomChoose(2, rabbits.length); i++) {
            rabbits[i] = new Rabbit();
        }
        for (int i = 0; i < UtilMethods.randomChoose(2, sheep.length); i++) {
            sheep[i] = new Sheep();
        }
        for (int i = 0; i < UtilMethods.randomChoose(2, mice.length); i++) {
            mice[i] = new Mouse();
        }
        for (int i = 0; i < UtilMethods.randomChoose(2, horses.length); i++) {
            horses[i] = new Horse();
        }
        for (int i = 0; i < UtilMethods.randomChoose(2, boars.length); i++) {
            boars[i] = new Boar();
        }
        for (int i = 0; i < UtilMethods.randomChoose(2, goats.length); i++) {
            goats[i] = new Goat();
        }
        for (int i = 0; i < UtilMethods.randomChoose(2, ducks.length); i++) {
            ducks[i] = new Duck();
        }
        for (int i = 0; i < UtilMethods.randomChoose(2, deer.length); i++) {
            deer[i] = new Deer();
        }
        for (int i = 0; i < UtilMethods.randomChoose(2, caterpillars.length); i++) {
            caterpillars[i] = new Caterpillar();
        }
        for (int i = 0; i < UtilMethods.randomChoose(2, buffalo.length); i++) {
            buffalo[i] = new Buffalo();
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

    public double getPlants() {
        return plant.currentWeight;
    }

    public void info () {
        String kindOfAnimal = "";

        for (Animal[] a : animals) {
            int count = 0;
            kindOfAnimal = switch (a.getClass().getSimpleName()) {
                case "Wolf[]" -> Settings.WOLF;
                case "Snake[]" -> Settings.SNAKE;
                case "Fox[]" -> Settings.FOX;
                case "Bear[]" -> Settings.BEAR;
                case "Eagle[]" -> Settings.EAGLE;
                case "Boar[]" -> Settings.BOAR;
                case "Buffalo[]" -> Settings.BUFFALO;
                case "Caterpillar[]" -> Settings.CATERPILLAR;
                case "Deer[]" -> Settings.DEER;
                case "Duck[]" -> Settings.DUCK;
                case "Goat[]" -> Settings.GOAT;
                case "Horse[]" -> Settings.HORSE;
                case "Sheep[]" -> Settings.SHEEP;
                case "Mouse[]" -> Settings.MOUSE;
                case "Rabbit[]" -> Settings.RABBIT;
                default -> kindOfAnimal;
            };
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
