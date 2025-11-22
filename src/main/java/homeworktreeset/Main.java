package homeworktreeset;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        Comparator<Person> byAge = Comparator.comparingInt(a -> a.age);
        TreeSet<Person> persons1 = new TreeSet<>(byAge);
        persons1.add(new Person("Oltita", 5));
        persons1.add(new Person("Hugo", 10));
        persons1.add(new Person("Marieta", 15));
        persons1.add(new Person("Radu", 25));
        {
            System.out.println(persons1);
        }

        Comparator<Person> byName = Comparator.comparing(p -> p.name);
        TreeSet<Person> persons2 = new TreeSet<>(byName);
        persons2.add(new Person("Oltita", 5));
        persons2.add(new Person("Hugo", 10));
        persons2.add(new Person("Marieta", 15));
        persons2.add(new Person("Radu", 25));
        {
            System.out.println(persons2);
        }


        HashMap<Person, List<Hobby>> hobbiesList2 = new HashMap<>();
        hobbiesList2.put(new Person("Oltita", 5), Arrays.asList(
                new Hobby("Running", 100, "Romania")));
        hobbiesList2.put(new Person("Hugo", 10), Arrays.asList(
                new Hobby("Triathlon", 8, "Italy")));
        hobbiesList2.put(new Person("Radu", 25), Arrays.asList(
                new Hobby("Swimming", 100, "Romania")));
        hobbiesList2.put(new Person("Marieta", 15), Arrays.asList(
                new Hobby("Trekking", 90, "Romania")
        ));

        Person target = new Person("Oltita", 5);
        List<Hobby> hobbies = hobbiesList2.get(target);
        if (hobbies != null) {
            System.out.println("Hobbies for " + target.name + ":");
            for (Hobby h : hobbies) {
                System.out.println(" - " + h.getName() + " in " + h.getCountry());
            }
        } else {
            System.out.println("No hobbies found for " + target.name);

        }
    }
}







