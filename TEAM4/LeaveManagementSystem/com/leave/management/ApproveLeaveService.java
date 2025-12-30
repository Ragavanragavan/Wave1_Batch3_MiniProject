package com.leave.management;

public class ApproveLeaveService {

    public boolean approve(Employee emp, LeaveRequest leave) {

        if (emp.getLeaveBalance() >= leave.getDays()) {
            emp.deductLeave(leave.getDays());
            leave.approve();
            return true;
        }
        return false;
    }

    public void reject(LeaveRequest leave) {
        leave.reject();
    }
}
