package model;

public class FullTimeEmployee extends Employee {

    private double basicSalary;
    private double hra;
    private double da;
    private double taxPercentage;

    public FullTimeEmployee(int id, String name,
                            double basicSalary, double hra,
                            double da, double taxPercentage) {
        super(id, name);
        this.basicSalary = basicSalary;
        this.hra = hra;
        this.da = da;
        this.taxPercentage = taxPercentage;
    }

    @Override
    public double calculateSalary() {
        double grossSalary = basicSalary + hra + da;
        double tax = grossSalary * taxPercentage / 100;
        return grossSalary - tax;
    }
}
