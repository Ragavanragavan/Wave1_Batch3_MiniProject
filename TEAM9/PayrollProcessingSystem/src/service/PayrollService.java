package service;

import exception.InvalidSalaryException;
import model.Employee;

public class PayrollService {

    public double processPayroll(Employee employee) throws InvalidSalaryException {

        double netSalary = employee.calculateSalary();

        if (netSalary <= 0) {
            throw new InvalidSalaryException("Calculated salary is invalid");
        }

        return netSalary;
    }
}
