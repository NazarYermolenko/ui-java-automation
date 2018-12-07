package workers;


public abstract class Employee {

    protected String firstName;
    protected String lastName;
    protected double salary;
    protected int id;

    public Employee(int id, String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public double getMonthlySalary() {
        return this.salary;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return (this.id + "\t" + this.firstName + " " + this.lastName + "\t" + getMonthlySalary() + "\n");
    }
}