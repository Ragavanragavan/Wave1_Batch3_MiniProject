package com.leave.management;

import java.time.LocalDate;
import java.time.YearMonth;

public class ApplyLeaveService {

    public LeaveRequest applyLeave(
            LocalDate start,
            LocalDate end,
            int leaveChoice) throws Exception {

        YearMonth current = YearMonth.now();
        YearMonth next = current.plusMonths(1);
        YearMonth startMonth = YearMonth.from(start);

        if (!(startMonth.equals(current) || startMonth.equals(next))) {
            throw new Exception("Leave allowed only for current or next month");
        }

        if (end.isBefore(start)) {
            throw new Exception("End date cannot be before start date");
        }

        String leaveType;
        if (leaveChoice == 1) {
            leaveType = "Sick Leave";
        } else if (leaveChoice == 2) {
            leaveType = "Casual Leave";
        } else {
            throw new Exception("Invalid Leave Type");
        }

        return new LeaveRequest(start, end, leaveType);
    }
}
