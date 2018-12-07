package workers;

public class FixedSalaryEmployee extends Employee {

    public FixedSalaryEmployee(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        this.salary = salary;
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }
}