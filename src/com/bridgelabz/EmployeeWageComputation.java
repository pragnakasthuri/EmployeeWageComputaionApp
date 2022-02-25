/**
 * Ability to manage Employee Wage of multiple companies - Note: Refactor to
 */
package com.bridgelabz;

import java.util.Scanner;

class Company {
    private String companyName;
    private int totalNoOfWorkingDays;
    private int maxWorkingHrsPerMonth;
    private int wagePerHr;
    private int totalEmployeeWage;

    /**
     * @param companyName
     * @param totalNoOfWorkingDays
     * @param maxWorkingHrsPerMonth
     * @param wagePerHr
     */
    public Company(String companyName, int totalNoOfWorkingDays, int maxWorkingHrsPerMonth, int wagePerHr) {
        this.companyName = companyName;
        this.totalNoOfWorkingDays = totalNoOfWorkingDays;
        this.maxWorkingHrsPerMonth = maxWorkingHrsPerMonth;
        this.wagePerHr = wagePerHr;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getTotalNoOfWorkingDays() {
        return totalNoOfWorkingDays;
    }

    public void setTotalNoOfWorkingDays(int totalNoOfWorkingDays) {
        this.totalNoOfWorkingDays = totalNoOfWorkingDays;
    }

    public int getMaxWorkingHrsPerMonth() {
        return maxWorkingHrsPerMonth;
    }

    public void setMaxWorkingHrsPerMonth(int maxWorkingHrsPerMonth) {
        this.maxWorkingHrsPerMonth = maxWorkingHrsPerMonth;
    }

    public int getWagePerHr() {
        return wagePerHr;
    }

    public void setWagePerHr(int wagePerHr) {
        this.wagePerHr = wagePerHr;
    }

    public int getTotalEmployeeWage() {
        return totalEmployeeWage;
    }

    public void setTotalEmployeeWage(int totalEmployeeWage) {
        this.totalEmployeeWage = totalEmployeeWage;
    }

    @Override
    public String toString() {
        return this.companyName +
                ", totalEmployeeWage=" + totalEmployeeWage;
    }
}

public class EmployeeWageComputation {
    /**
     * Declaring constants
     */
    private static final int FUL_TIME_HRS = 8;
    private static final int PART_TIME_HRS = 4;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /**
         * Here passing values from user input
         */
        Company[] companyArray = new Company[2];
        companyArray[0] = readEmployeeDetails(scanner);
        companyArray[1] = readEmployeeDetails(scanner);

        for (int i=0; i<companyArray.length; i++) {
            Company company = companyArray[i];
            company.setTotalEmployeeWage(calculateEmployeeWage(company));
            System.out.println(company);
        }
        scanner.close();
    }

    /**
     * @param company
     * @return Employee Wage for a company
     */
    public static int calculateEmployeeWage(Company company) {
        Employee employee = new Employee();
        employee.setEmployeeType(EmployeeType.FULL_TIME);
        while (employee.getEmpHrs() <= company.getTotalNoOfWorkingDays()
                && employee.getTotalNoOfEmpWorkingDays() < company.getMaxWorkingHrsPerMonth()) {
            if (employee.isPresent()) {
                switch (employee.getEmployeeType()) {
                    case FULL_TIME:
                        employee.setEmpHrs(employee.getEmpHrs() + FUL_TIME_HRS);
                        break;
                    case PART_TIME:
                        employee.setEmpHrs(employee.getEmpHrs() + PART_TIME_HRS);
                        break;
                    default:
                        System.out.println("Invalid employee type!");
                        break;
                }
            }
        }
        return employee.getEmpHrs() * company.getWagePerHr();
    }

    /**
     * @param scanner
     * @return The values given by the user as employee object
     */
    public static Company readEmployeeDetails(Scanner scanner) {
        System.out.println("Enter company name");
        String companyName = scanner.next();
        System.out.println("Enter Max working days");
        int totalNoOfWorkingDays = scanner.nextInt();
        System.out.println("Enter Max working hours");
        int maxWorkingHrsPerMonth = scanner.nextInt();
        System.out.println("Enter wage per hour");
        int rate = scanner.nextInt();
        return new Company(companyName, totalNoOfWorkingDays, maxWorkingHrsPerMonth, rate);
    }
}

