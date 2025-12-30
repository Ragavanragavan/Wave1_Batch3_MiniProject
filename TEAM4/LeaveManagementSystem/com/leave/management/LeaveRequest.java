package com.leave.management;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LeaveRequest {

    public LocalDate startDate;
    public LocalDate endDate;
    private int days;
    private String leaveType; // Sick / Casual
    public boolean approved;
    public boolean rejected;

    public LeaveRequest(LocalDate startDate, LocalDate endDate, String leaveType) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.leaveType = leaveType;
        this.days = (int) ChronoUnit.DAYS.between(startDate, endDate) + 1;
        this.approved = false;
        this.rejected = false;
    }

    public int getDays() {
        return days;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void approve() {
        approved = true;
        rejected = false;
    }

    public void reject() {
        rejected = true;
        approved = false;
    }
}
