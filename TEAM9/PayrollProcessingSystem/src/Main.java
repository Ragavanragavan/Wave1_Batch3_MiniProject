import model.*;
import service.*;
import exception.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PayrollService payrollService = new PayrollService();

        try {
            System.out.println("===== PAYROLL PROCESSING SYSTEM =====");

            // Government compliance (tax update)
            System.out.print("Enter current government tax percentage: ");
            double tax = sc.nextDouble();
            GovernmentComplianceService.updateTax(tax);

            System.out.println("\nSelect Employee Type:");
            System.out.println("1. Full-Time Employee");
            System.out.println("2. Part-Time Employee");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();

            Employee employee;

            if (choice == 1) {
                // Full-time employee input
                System.out.print("Enter Basic Salary: ");
                double basic = sc.nextDouble();

                System.out.print("Enter HRA: ");
                double hra = sc.nextDouble();

                System.out.print("Enter DA: ");
                double da = sc.nextDouble();

                employee = new FullTimeEmployee(
                        id, name, basic, hra, da,
                        GovernmentComplianceService.getTax()
                );

            } else if (choice == 2) {
                // Part-time employee input
                System.out.print("Enter Hours Worked: ");
                int hours = sc.nextInt();

                System.out.print("Enter Rate Per Hour: ");
                double rate = sc.nextDouble();

                employee = new PartTimeEmployee(id, name, hours, rate);

            } else {
                throw new InvalidEmployeeTypeException("Invalid employee type selected");
            }

            // Payroll processing
            double netSalary = payrollService.processPayroll(employee);

            System.out.println("\n--- PAYSLIP ---");
            System.out.println("Employee ID   : " + employee.getEmployeeId());
            System.out.println("Employee Name : " + employee.getName());
            System.out.println("Net Salary    : ₹" + netSalary);

            // Bank details
            sc.nextLine();
            System.out.print("\nEnter Bank Name: ");
            String bank = sc.nextLine();

            System.out.print("Enter Account Number: ");
            String accountNo = sc.nextLine();

            System.out.print("Enter Current Account Balance: ");
            double balance = sc.nextDouble();

            BankAccount account = new BankAccount(bank, accountNo, balance);

            // Direct bank transfer
            BankTransferService.transferSalary(account, netSalary);

        } catch (InvalidSalaryException | InvalidEmployeeTypeException e) {
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
