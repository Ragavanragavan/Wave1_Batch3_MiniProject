package model;

public class PartTimeEmployee extends Employee {

    private int hoursWorked;
    private double ratePerHour;

    public PartTimeEmployee(int id, String name,
                            int hoursWorked, double ratePerHour) {
        super(id, name);
        this.hoursWorked = hoursWorked;
        this.ratePerHour = ratePerHour;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * ratePerHour;
    }
}
