package com.leave.management;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Store employees using Collection
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "Kavya", 10));
        employees.add(new Employee(102, "Anusha", 12));
        employees.add(new Employee(103, "Dharshini", 8));
        employees.add(new Employee(104, "Riya", 15));
        employees.add(new Employee(105, "Suresh", 10));

        LeaveRequest appliedLeave = null;
        Employee selectedEmp = null;

        while (true) {

            System.out.println("\n--- Corporate Leave Management System ---");
            System.out.println("1. Apply Leave");
            System.out.println("2. Approve / Reject Leave");
            System.out.println("3. Exit");
            System.out.print("Enter option: ");

            int option = sc.nextInt();

            if (option == 3) {
                System.out.println("Exiting system...");
                break;
            }

            if (option != 1 && option != 2) {
                System.out.println("Invalid option. Please choose 1 or 2 only.");
                continue;
            }

            try {
                // Ask Employee ID
                System.out.print("Enter Employee ID: ");
                int empId = sc.nextInt();

                selectedEmp = null;
                for (Employee e : employees) {
                    if (e.getEmpId() == empId) {
                        selectedEmp = e;
                        break;
                    }
                }

                if (selectedEmp == null) {
                    throw new Exception("Invalid Employee ID");
                }

                System.out.println("Employee Name: " + selectedEmp.getName());
                System.out.println("Available Leave Balance: " + selectedEmp.getLeaveBalance());

                // ================= APPLY LEAVE =================
                if (option == 1) {

                    System.out.println("Choose Leave Type:");
                    System.out.println("1. Sick Leave");
                    System.out.println("2. Casual Leave");
                    System.out.print("Enter choice: ");
                    int leaveChoice = sc.nextInt();

                    System.out.print("Enter Start Date (YYYY-MM-DD): ");
                    LocalDate start = LocalDate.parse(sc.next());

                    System.out.print("Enter End Date (YYYY-MM-DD): ");
                    LocalDate end = LocalDate.parse(sc.next());

                    ApplyLeaveService applyService = new ApplyLeaveService();
                    appliedLeave = applyService.applyLeave(start, end, leaveChoice);

                    System.out.println("Leave Applied Successfully");
                    System.out.println("Leave Type: " + appliedLeave.getLeaveType());
                    System.out.println("Total Leave Days: " + appliedLeave.getDays());
                }

                // ================= APPROVE / REJECT =================
                if (option == 2) {

                    if (appliedLeave == null) {
                        System.out.println("No leave applied yet");
                        continue;
                    }

                    System.out.println("Leave Type: " + appliedLeave.getLeaveType());
                    System.out.println("Leave Days: " + appliedLeave.getDays());

                    System.out.println("1. Approve Leave");
                    System.out.println("2. Reject Leave");
                    System.out.print("Enter decision: ");
                    int decision = sc.nextInt();

                    ApproveLeaveService approveService = new ApproveLeaveService();

                    if (decision == 1) {
                        boolean approved = approveService.approve(selectedEmp, appliedLeave);

                        if (approved) {
                            System.out.println("Leave Approved");
                            System.out.println("Remaining Balance: " + selectedEmp.getLeaveBalance());
                        } else {
                            System.out.println("Leave Rejected (Insufficient Balance)");
                        }

                    } else if (decision == 2) {
                        approveService.reject(appliedLeave);
                        System.out.println("Leave Rejected by Manager");
                    } else {
                        System.out.println("Invalid approval option");
                    }
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        sc.close();
    }
}
