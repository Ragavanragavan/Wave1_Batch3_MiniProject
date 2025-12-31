package test;

import model.*;
import service.*;
import exception.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class PayrollSystemTest {

    /* -----------------------------
       Full-Time Employee Tests
       ----------------------------- */

    @Test
    public void testFullTimeSalaryCalculation() {
        Employee emp = new FullTimeEmployee(
                1, "Arjun", 30000, 8000, 5000, 10
        );

        double salary = emp.calculateSalary();
        assertEquals(38700, salary, 0.001);
    }

    /* -----------------------------
       Part-Time Employee Tests
       ----------------------------- */

    @Test
    public void testPartTimeSalaryCalculation() {
        Employee emp = new PartTimeEmployee(
                2, "Rahul", 100, 300
        );

        double salary = emp.calculateSalary();
        assertEquals(30000, salary, 0.001);
    }

    /* -----------------------------
       Payroll Service Tests
       ----------------------------- */

    @Test
    public void testPayrollProcessing() throws InvalidSalaryException {
        Employee emp = new FullTimeEmployee(
                3, "Test", 20000, 5000, 3000, 10
        );

        PayrollService service = new PayrollService();
        double netSalary = service.processPayroll(emp);

        assertTrue(netSalary > 0);
    }

    @Test(expected = InvalidSalaryException.class)
    public void testInvalidSalaryException() throws InvalidSalaryException {
        Employee emp = new PartTimeEmployee(
                4, "Invalid", 0, 0
        );

        PayrollService service = new PayrollService();
        service.processPayroll(emp);
    }

    /* -----------------------------
       Government Compliance Tests
       ----------------------------- */

    @Test
    public void testGovernmentTaxUpdate() {
        GovernmentComplianceService.updateTax(15);
        assertEquals(15, GovernmentComplianceService.getTax(), 0.001);
    }

    /* -----------------------------
       Bank Transfer Tests
       ----------------------------- */

    @Test
    public void testBankTransfer() {

        BankAccount account = new BankAccount(
                "SBI", "123456", 10000
        );

        BankTransferService.transferSalary(account, 5000);

        assertEquals(15000, account.getBalance(), 0.001);
    }
}
