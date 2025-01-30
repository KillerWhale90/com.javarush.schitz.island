package entity.creature.animal;

import entity.creature.Creature;
import util.Direction;
import util.Settings;
import util.UtilMethods;

public abstract class Animal extends Creature {

/*
    public double currentWeight;
    public double maxWeight;
    public int MAX_COUNT_ON_LOCATION;
    public int x;
    public int y;
*/

    public int maxSpeed;

    public double needFeedToWellfed;

    public boolean isAlive = true;

    public void eat(Creature c) {
        // ДЕФОЛТНАЯ РЕАЛИЗАЦИЯ
        // КТО ИМЕННО ЭТОТ Creature БУДЕТ ВЛИЯТЬ НА ФОРМАТ ПОЕДАНИЯ
        // КОГДА СТАНЕТ ПОНЯТНО КТО КОНКРЕТНО ЭТО Creature
        // МЫ МОЖЕМ ОПРЕДЕЛИТЬ ВЕРОЯТНОСТЬ ЕГО ПОЕДАНИЯ И РЕАЛИЗОВАТЬ ЭТУ ЛОГИКУ
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

    public Animal reproduce(Animal a) {
        // ДЕФОЛТНАЯ РЕАЛИЗАЦИЯ
        if(this.isAlive && a.isAlive && this.getClass().getName().equals(a.getClass().getName())){
        }
        return null;
    }

    public void die() {
        // ДЕФОЛТНАЯ РЕАЛИЗАЦИЯ
        if(currentWeight < maxWeight / 2){
            isAlive = false;
        }
    }

    public void decreaseWeight() {
        currentWeight = currentWeight - (currentWeight/20);
    }
}
