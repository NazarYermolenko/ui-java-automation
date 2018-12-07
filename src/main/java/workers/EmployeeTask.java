package workers;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EmployeeTask {
    public static void main(String[] args) {
        List<Employee> fixedSalaryEmployee = new ArrayList<>();
        fixedSalaryEmployee.add(new FixedSalaryEmployee(1, "John", "Adams", 200.0));
        fixedSalaryEmployee.add(new FixedSalaryEmployee(2, "Nazar", "Yermo", 300.0));
        fixedSalaryEmployee.add(new FixedSalaryEmployee(3, "Micha", "Cccc", 400.0));
        fixedSalaryEmployee.add(new FixedSalaryEmployee(4, "Julia", "Conor", 100.0));
        fixedSalaryEmployee.add(new FixedSalaryEmployee(5, "Alex", "Jeren", 250.0));
        fixedSalaryEmployee.add(new FixedSalaryEmployee(6, "Maria", "Shum", 350.0));


        List<Employee> hourlySalaryEmployee = new ArrayList<>();
        hourlySalaryEmployee.add(new HourSalaryEmployee(1, "John", "Adams", 2.0));
        hourlySalaryEmployee.add(new HourSalaryEmployee(2, "Nazar", "Yermo", 2.0,
                22.0, 7.0));
        hourlySalaryEmployee.add(new HourSalaryEmployee(3, "Micha", "Shum", 2.0));
        hourlySalaryEmployee.add(new HourSalaryEmployee(4, "Julia", "Jeren", 2.0,
                25.0, 6.0));
        hourlySalaryEmployee.add(new HourSalaryEmployee(5, "Huan", "Linus", 2.0));
        hourlySalaryEmployee.add(new HourSalaryEmployee(6, "Alex", "Conor", 2.0,
                23.0, 5.0));


        Comparator employeeComparator = Comparator.comparing(Employee::getMonthlySalary)
                .thenComparing(Employee::getLastName);

        hourlySalaryEmployee.sort(employeeComparator);
        fixedSalaryEmployee.sort(employeeComparator);
        System.out.println("Output sorted lists:");
        hourlySalaryEmployee.forEach(System.out::print);
        fixedSalaryEmployee.forEach(System.out::print);

        System.out.println("Output first five name from sorted lists:");
        hourlySalaryEmployee.stream().limit(5).forEach(employee -> System.out.println(employee.getFirstName()));
        fixedSalaryEmployee.stream().limit(5).forEach(employee -> System.out.println(employee.getFirstName()));

        System.out.println("Output last three ID from sorted lists:");
        hourlySalaryEmployee.stream().skip(hourlySalaryEmployee.size() - 3)
                .forEach(employee -> System.out.println(employee.getId()));
        fixedSalaryEmployee.stream().skip(hourlySalaryEmployee.size() - 3)
                .forEach(employee -> System.out.println(employee.getId()));
    }

}