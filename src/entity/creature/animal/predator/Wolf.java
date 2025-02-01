package entity.creature.animal.predator;

public class Wolf extends Predator{

    public Wolf() {
        this.maxWeight = 50;
        this.currentWeight = maxWeight;
        this.needFeedToWellfed = 8;
        this.isAlive = true;
        this.maxSpeed = 3;
        initPossibleFood();
    }

    public void initPossibleFood () {
        this.possibleFood.put("Rabbit", 60);
    }
}

