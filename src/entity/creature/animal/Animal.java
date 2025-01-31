package entity.creature.animal;

import entity.creature.Creature;
import entity.creature.plant.Plant;
import util.AnimalFactory;
import util.Direction;
import util.Settings;
import util.UtilMethods;

import java.lang.reflect.Constructor;

public abstract class Animal extends Creature {

    public int maxSpeed;

    public double needFeedToWellfed;

    public boolean isAlive = true;

    public void eat(Animal animal) {

    }

    public void eat(Plant plant) {

    }

    public void move() {
        // ДЕФОЛТНАЯ РЕАЛИЗАЦИЯ
        int speed = UtilMethods.randomChoose(0, maxSpeed);
        Direction direction = UtilMethods.randomDirection();

        if(isAlive){
            if(direction == Direction.UP && y != 0 && y - speed >= 0){
                y = y - speed;
            }
            if(direction == Direction.DOWN && y != Settings.ROWS_COUNT - 1 && y + speed <= Settings.ROWS_COUNT - 1){
                y = y + speed;
            }
            if(direction == Direction.LEFT && x != 0 && x - speed >= 0){
                x = x - speed;
            }
            if(direction == Direction.RIGHT && x != Settings.COLUMNS_COUNT - 1 && x + speed <= Settings.COLUMNS_COUNT - 1){
                x = x + speed;
            }
        }
    }

    public void reproduce(Animal a, Animal[] animals) {
        // ДЕФОЛТНАЯ РЕАЛИЗАЦИЯ
        Animal newAnimal = null;

        if(a != null){
            if(this.isAlive && a.isAlive && this.getClass().getName().equals(a.getClass().getName())){
                newAnimal = new AnimalFactory().createNewAnimal(a);
                for (int i = 0; i < animals.length; i++) {
                    if(animals[i] == null){
                        animals[i] = newAnimal;
                        break;
                    }
                }
            }
        }
    }

    public void die() {
        if(currentWeight < (maxWeight / 2)){
            isAlive = false;
        }
    }

    public void die(Animal animal){
        isAlive = false;
    }

    public void decreaseWeight() {
        currentWeight = currentWeight - (currentWeight/10);
    }
}
