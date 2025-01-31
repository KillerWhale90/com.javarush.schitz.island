package util;

import entity.creature.animal.Animal;
import entity.creature.animal.herbivore.Rabbit;
import entity.creature.animal.predator.Wolf;

public class AnimalFactory {

    public Animal createNewAnimal (Animal animal) {
        Animal newAnimal = null;

        if(animal instanceof Wolf){
            newAnimal = new Wolf();
        } else if (animal instanceof Rabbit) {
            newAnimal = new Rabbit();
        }

        return newAnimal;
    }
}
