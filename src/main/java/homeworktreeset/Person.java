package homeworktreeset;

import java.util.List;
import java.util.Objects;


public class Person {

    String name;
    int age;
    List<Hobby> hobbies;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", age=" + age + '}';
    }

    @Override
    public boolean equals(Object p) {
        if (this == p) return true;
        if (!(p instanceof Person)) return false;
        Person other = (Person) p;
        return age == other.age && Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}


