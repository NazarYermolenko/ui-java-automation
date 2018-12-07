package collections;


import java.util.*;

public class CollectionTask {

    public static void main(String[] args) {
        List<Human> humans = new ArrayList<>();
        Map<Integer, Human> humansMap = new HashMap<>();

        humansMap.put(Human.getCounter(), new Human("John", 32));
        humansMap.put(Human.getCounter(), new Human("John", 23));
        humansMap.put(Human.getCounter(), new Human("Michael", 24));
        humansMap.put(Human.getCounter(), new Human("Nazar", 25));

        humans.add(new Human("Nazar", 22));
        humans.add(new Human("John", 32));
        humans.add(new Human("Michael", 23));
        humans.add(new Human("Ann", 45));

        System.out.println("Work with list:");
        printList(humans);
        ListIterator<Human> iterator = humans.listIterator();
        while (iterator.hasNext()) {
            if (iterator.next().getAge() > 23) {
                iterator.remove();
            }
        }
        System.out.println("Result:");
        printList(humans);


        System.out.println("\nWork with map:");
        printMap(humansMap);
        humansMap.entrySet().removeIf(humanEntry -> humanEntry.getValue().getAge() > 23);

        System.out.println("Result:");
        printMap(humansMap);
    }

    public static void printMap(Map<?, ?> map) {
        map.forEach((key, value) -> System.out.println(key + " " + value));
    }

    public static void printList(List<?> list) {
        list.forEach(System.out::println);
    }
}
