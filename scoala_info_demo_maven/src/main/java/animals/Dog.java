package animals;

public class Dog extends Animal implements Pet, Carnivore {
    public Dog(String name, String habitat) {
        super(name, habitat);
    }

    @Override
    public void play() {
        System.out.println("Playing...");

    }

    @Override
    public void makeSound() {
        System.out.println("Barking...");

    }

    @Override
    public void move() {
        System.out.println("Walking...");

    }

    @Override
    public void eatMeat() {
        System.out.println("Eat meat");
    }
}
