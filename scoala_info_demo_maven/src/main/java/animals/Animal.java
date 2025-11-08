package animals;

public abstract class Animal {
    private String name;
    private String habitat;
    public Animal(String name, String habitat) {
        this.name = name;
        this.habitat = habitat;
    }

    public void eat() {
        System.out.println("Eating...");
    }

    public abstract void makeSound();

    public abstract void move();
}


