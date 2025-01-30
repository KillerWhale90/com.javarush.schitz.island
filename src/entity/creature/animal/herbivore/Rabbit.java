package entity.creature.animal.herbivore;

public class Rabbit extends Herbivore{

    public Rabbit () {
        this.maxWeight = 2;
        this.currentWeight = maxWeight;
        this.needFeedToWellfed = 0.45;
        this.isAlive = true;
    }
}
