package model;

public class BankAccount {

    private String bankName;
    private String accountNumber;
    private double balance;

    public BankAccount(String bankName, String accountNumber, double balance) {
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getBankName() {
        return bankName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void credit(double amount) {
        balance += amount;
    }
}
