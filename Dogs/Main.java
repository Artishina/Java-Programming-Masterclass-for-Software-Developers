package Dogs;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Labrador rover = new Labrador("Rover");
        Dog rover2 = new Dog("Rover");

        System.out.println(rover2.equals(rover));
        System.out.println(rover.equals(rover2));

        Set<Dog> dogs = new HashSet<>();
        dogs.add(rover);
        dogs.add(rover2);
        
        Dog bucha = new Dog("Bucha");

        dogs.add(bucha);

        // only one Rover, because the second is consideted a duplicate thanks to overrided hashCode method
        for (Dog dog : dogs) {
            System.out.println("dog: " + dog.getName());
        }

    }
    
}
