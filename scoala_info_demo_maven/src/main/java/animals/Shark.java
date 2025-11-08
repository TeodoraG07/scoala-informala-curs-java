package animals;

public class Shark extends Animal implements Carnivore {
    public Shark(String name, String habitat) {
        super(name, habitat);
    }

    @Override
    public void eatMeat() {
        System.out.println("Eat meat");
    }

    @Override
    public void makeSound() {
        System.out.println("Shark is making sound");
    }

    @Override
    public void move() {
        System.out.println("Shark is moving");

    }
}
