package workers;

public class HourSalaryEmployee extends Employee {
    private static final double DEFAULT_WORK_DAYS = 20.0;
    private static final double DEFAULT_WORK_HOURS = 8.0;

    private double workDays;
    private double workHours;
    private double hourlyRate;

    public HourSalaryEmployee(int id, String firstName, String lastName,
                              double hourlyRate, double workDays, double workHours) {
        super(id, firstName, lastName);
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.workDays = workDays;
        this.workHours = workHours;
        this.hourlyRate = hourlyRate;
        this.salary = calculateMonthlySalary();
    }

    public HourSalaryEmployee(int id, String firstName, String lastName, double hourlyRate) {
        super(id, firstName, lastName);
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.workDays = DEFAULT_WORK_DAYS;
        this.workHours = DEFAULT_WORK_HOURS;
        this.hourlyRate = hourlyRate;
        this.salary = calculateMonthlySalary();
    }

    private double calculateMonthlySalary() {
        return this.hourlyRate * this.workDays * this.workHours;
    }
}