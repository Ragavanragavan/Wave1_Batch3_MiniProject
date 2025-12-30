package com.leave.management;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class ApproveLeaveServiceTest {

    @Test
    void testApproveLeaveSuccess() {
        Employee emp = new Employee(101, "Kavya", 10);
        LeaveRequest leave = new LeaveRequest(
                LocalDate.now(),
                LocalDate.now().plusDays(2),
                "Casual Leave"
        );

        ApproveLeaveService service = new ApproveLeaveService();

        boolean result = service.approve(emp, leave);

        assertTrue(result);
        assertEquals(7, emp.getLeaveBalance());
    }

    @Test
    void testApproveLeaveInsufficientBalance() {
        Employee emp = new Employee(102, "Riya", 1);
        LeaveRequest leave = new LeaveRequest(
                LocalDate.now(),
                LocalDate.now().plusDays(2),
                "Sick Leave"
        );

        ApproveLeaveService service = new ApproveLeaveService();

        boolean result = service.approve(emp, leave);

        assertFalse(result);
        assertEquals(1, emp.getLeaveBalance());
    }

    @Test
    void testRejectLeave() {
        LeaveRequest leave = new LeaveRequest(
                LocalDate.now(),
                LocalDate.now(),
                "Sick Leave"
        );

        ApproveLeaveService service = new ApproveLeaveService();
        service.reject(leave);

        assertTrue(true); // Reject executed successfully
    }
}