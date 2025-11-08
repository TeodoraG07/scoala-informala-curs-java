package animals;

public class Cat extends Animal implements Pet,Carnivore {
    public Cat (String name, String habitat) {
        super(name, habitat);
    }
    @Override
    public void eatMeat() {
        System.out.println("Eat meat");
    }

    @Override
    public void makeSound() {
        System.out.println("Miau...");
    }

    @Override
    public void move() {
        System.out.println("Walking...");
    }

    @Override
    public void play() {
        System.out.println("Playing...");
    }
}
