package util;

import entity.creature.animal.Animal;
import entity.creature.animal.herbivore.herbivores.*;
import entity.creature.animal.predator.predators.*;

public class AnimalFactory {

    public Animal createNewAnimal (Animal animal) {
        Animal newAnimal = null;

        if(animal instanceof Wolf){
            newAnimal = new Wolf();
        } else if (animal instanceof Snake) {
            newAnimal = new Snake();
        }  else if (animal instanceof Fox) {
            newAnimal = new Fox();
        }  else if (animal instanceof Eagle) {
            newAnimal = new Eagle();
        }  else if (animal instanceof Bear) {
            newAnimal = new Bear();
        }  else if (animal instanceof Rabbit) {
            newAnimal = new Rabbit();
        } else if (animal instanceof Sheep) {
            newAnimal = new Sheep();
        }  else if (animal instanceof Mouse) {
            newAnimal = new Mouse();
        }  else if (animal instanceof Horse) {
            newAnimal = new Horse();
        }  else if (animal instanceof Goat) {
            newAnimal = new Goat();
        }  else if (animal instanceof Duck) {
            newAnimal = new Duck();
        }  else if (animal instanceof Deer) {
            newAnimal = new Deer();
        }  else if (animal instanceof Caterpillar) {
            newAnimal = new Caterpillar();
        }  else if (animal instanceof Buffalo) {
            newAnimal = new Buffalo();
        }  else if (animal instanceof Boar) {
            newAnimal = new Boar();
        }

        return newAnimal;
    }
}
