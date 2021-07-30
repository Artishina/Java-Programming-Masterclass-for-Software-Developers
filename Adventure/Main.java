package Adventure;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();

    public static void main(String[] args) {

        Map<String, String> directions = new HashMap<String, String>(4);
        directions.put("WEST", "W");
        directions.put("EAST", "E");
        directions.put("SOUTH", "S");
        directions.put("NORTH", "N");
        directions.put("QUIT", "Q");

        try (Scanner scanner = new Scanner(System.in)) {

            Map<String, Integer> tempExits = new HashMap<String, Integer>();
            locations.put(0, new Location(0, "You are sitting in front of a computer learning Java", null));
        
            tempExits = new HashMap<String, Integer>(4);
            tempExits.put("W", 2);
            tempExits.put("E", 3);
            tempExits.put("S", 4);
            tempExits.put("N", 5);            
            locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building", tempExits));

            tempExits = new HashMap<String, Integer>(1);
            tempExits.put("N", 5);
            locations.put(2, new Location(2, "You are at the top of a hill", tempExits));

            tempExits = new HashMap<String, Integer>(1);
            tempExits.put("W", 1);
            locations.put(3, new Location(3, "You are inside a building, a well house for a small spring", tempExits));

            tempExits = new HashMap<String, Integer>(2);
            tempExits.put("N", 1);
            tempExits.put("W", 2);           
            //tempExits.put("E", 6);    java.lang.NullPointerException    
            locations.put(4, new Location(4, "You are in a valley beside a stream", tempExits));

            tempExits = new HashMap<String, Integer>(2);
            tempExits.put("S", 1);
            tempExits.put("W", 2);
           // tempExits.put("N", 6);
            locations.put(5, new Location(5, "You are in the forest", tempExits));

            String[] road = "You are standing at the end of a road before a small brick building".split(" ");
            for (String i : road) {
                System.out.println(i);
            }

            System.out.println("==================================");

            String[] building = "You are inside a building, a well house for a small spring".split(", ");
            for (String i : building) {
                System.out.println(i);
            }

            int loc = 1;
            while (true) {
                System.out.println(locations.get(loc).getDescription());

                if (loc == 0) break;

                Map<String, Integer> exits = locations.get(loc).getExits();
                System.out.print("Available exits are ");
                for (String exit : exits.keySet()) {
                    System.out.print(exit + ", ");
                }
                System.out.println();

                String direction = scanner.nextLine().toUpperCase();

                if (direction.length() > 1) {
                    String[] words = direction.split(" ");
                    
                    for (String word : words) {
                        if (directions.containsKey(word)) {
                            direction = directions.get(word);
                            break;
                        }
                    }
                }

                /*
                String[] dirs = direction.split(" ");

                for (String dir : dirs) {

                    for (String key : directions.keySet()) {

                        String value = directions.get(key);

                        if (key.equals(dir) || value.equals(dir)) {
                            direction = value;
                        }
                    }
                }
                */

                if (exits.containsKey(direction)) {
                    loc = exits.get(direction);

                } else {
                    System.out.println("You cannot go in that direction");
                }

                if (!locations.containsKey(loc)) {
                    System.out.println("You cannot go there");
                }
            }
        }
    }
}
