package service;

public class GovernmentComplianceService {

    private static double taxPercentage = 10;

    public static void updateTax(double newTax) {
        taxPercentage = newTax;
        System.out.println("Government tax rules updated to " + taxPercentage + "%");
    }

    public static double getTax() {
        return taxPercentage;
    }
}
