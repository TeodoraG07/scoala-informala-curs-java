package animals;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<Animal>();
        Cat mycat = new Cat("Pisi", "big homes");
        Dog mydog = new Dog("Ham", "small homes");
        Dog mydog2 = new Dog("Pam", "small homes");
        Shark myshark = new Shark("Shark", "bog waters");
        animals.add(mycat);
        animals.add(mydog);
        animals.add(myshark);
        for (Animal currentAnimal : animals) {
            currentAnimal.makeSound();
        }
        List<Dog> animals2 = new ArrayList<>();
        animals2.add(mydog);
        animals2.add(mydog2);
        for (Dog currentDog : animals2) {
            currentDog.makeSound();
            currentDog.move();
            currentDog.makeSound();
            currentDog.play();

        }
        List<Pet> animals3 = new ArrayList<>();
        animals3.add(mycat);
        animals3.add(mydog);
        for (Pet currentPet : animals3) {
            currentPet.play();

        }

    }
}
