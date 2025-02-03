package entity.creature.animal;

import entity.Location;
import entity.creature.Creature;
import entity.creature.plant.Plant;
import util.AnimalFactory;
import util.Direction;
import util.Settings;
import util.UtilMethods;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal extends Creature {

    public int maxSpeed;

    public double needFeedToWellfed;

    public boolean isAlive = true;

    public void eat(Animal animal) {

    }

    public void eat(Plant plant) {

    }

    public void move(Location[][] locations) {
        // ДЕФОЛТНАЯ РЕАЛИЗАЦИЯ
        int speed = UtilMethods.randomChoose(0, maxSpeed);

        Direction direction = UtilMethods.randomDirection();

        int tempX = this.x;
        int tempY = this.y;

        if(this.isAlive){
            if(direction == Direction.UP && this.y != 0 && this.y - speed >= 0){
                this.y = this.y - speed;
            }
            if(direction == Direction.DOWN && this.y != Settings.ROWS_COUNT - 1 && this.y + speed <= Settings.ROWS_COUNT - 1){
                this.y = this.y + speed;
            }
            if(direction == Direction.LEFT && this.x != 0 && this.x - speed >= 0){
                this.x = this.x - speed;
            }
            if(direction == Direction.RIGHT && this.x != Settings.COLUMNS_COUNT - 1 && this.x + speed <= Settings.COLUMNS_COUNT - 1){
                this.x = this.x + speed;
            }
        }

        String className = this.getClass().getSimpleName() + "[]";

        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations.length; j++) {
                if(this.y == i && this.x == j){
                    for (Animal[] animals : locations[i][j].animals) {
                        if(className.equals(animals.getClass().getSimpleName())){
                            for (int k = 0; k < animals.length; k++) {
                                if(animals[k] == null){
                                    animals[k] = this;
                                    for (Animal[] animals1 : locations[tempY][tempX].animals) {
                                        if(className.equals(animals1.getClass().getSimpleName())){
                                            for (int l = 0; l < animals1.length; l++) {
                                                if(this.equals(animals1[l])){
                                                    animals1[l] = null;
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void reproduce(Animal a, Animal[] animals) {
        // ДЕФОЛТНАЯ РЕАЛИЗАЦИЯ
        Animal newAnimal;

        int random = ThreadLocalRandom.current().nextInt(0,100);

        if(a != null){
            if(this.isAlive && a.isAlive && this.getClass().getName().equals(a.getClass().getName()) && random <= 10){
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
        animal.isAlive = false;
    }

    public void decreaseWeight() {
        currentWeight = currentWeight - (currentWeight/10);
    }
}
