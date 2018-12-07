package collections;

public class Human {
    private String name;
    private int age;
    private static int counter = 0;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
        counter++;
    }

    public int getAge() {
        return this.age;
    }

    public static int getCounter() {
        return counter;
    }

    @Override
    public String toString() {
        return this.name + " " + this.age;
    }
}
