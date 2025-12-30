package com.leave.management;

public class Employee {

    private int empId;
    private String name;
    private int leaveBalance;

    public Employee(int empId, String name, int leaveBalance) {
        this.empId = empId;
        this.name = name;
        this.leaveBalance = leaveBalance;
    }

    public int getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public int getLeaveBalance() {
        return leaveBalance;
    }

    public void deductLeave(int days) {
        leaveBalance -= days;
    }
}
