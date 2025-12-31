package service;

import model.BankAccount;

public class BankTransferService {

    public static void transferSalary(BankAccount account, double amount) {

        System.out.println("\n--- Bank Transfer Details ---");
        System.out.println("Bank Name      : " + account.getBankName());
        System.out.println("Account Number : " + account.getAccountNumber());
        System.out.println("Previous Balance: ₹" + account.getBalance());

        account.credit(amount);

        System.out.println("Amount Credited: ₹" + amount);
        System.out.println("Updated Balance: ₹" + account.getBalance());
        System.out.println("Transfer Status: SUCCESS");
    }
}
