/**
 * Refactor to have list of multiple companies to manage Employee Wage using Array List
 */
package com.bridgelabz;

import java.util.*;

class Company {
    private String companyName;
    private int totalNoOfWorkingDays;
    private int maxWorkingHrsPerMonth;
    private int wagePerHr;
    private int totalEmployeeWage;
    private Map<Integer, Integer> dailyWage = new HashMap<>();

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

    public void setDailyWage(Map<Integer, Integer> dailyWage) {
        this.dailyWage = dailyWage;
    }

    public Map<Integer, Integer> getDailyWage() {
        return dailyWage;
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
                ", totalEmployeeWage=" + totalEmployeeWage +
                ", Daily wage= "+ dailyWage;
    }
}

public class EmployeeWageComputation implements IEmployeeWageComputation{
    /**
     * Declaring constants
     */
    private static final int FUL_TIME_HRS = 8;
    private static final int PART_TIME_HRS = 4;
    private List<Company> companyList = new ArrayList<>();

    public List<Company> getCompanyList() {
        return companyList;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeWageComputation employeeWageComputation = new EmployeeWageComputation();
        /**
         * Here passing values from user input
         */
        employeeWageComputation.getCompanyList().add(employeeWageComputation.readEmployeeDetails(scanner));
        //employeeWageComputation.companyArray[1] = employeeWageComputation.readEmployeeDetails(scanner);

        for (Company company : employeeWageComputation.getCompanyList()) {
            company.setTotalEmployeeWage(employeeWageComputation.calculateEmployeeWage(company));
            System.out.println(company);
        }
        scanner.close();
    }

    /**
     * @param company
     * @return Employee Wage for a company
     */
    public int calculateEmployeeWage(Company company) {
        Employee employee = new Employee();
        employee.setEmployeeType(EmployeeType.FULL_TIME);
        int day = 0;
        while (employee.getEmpHrs() <= company.getMaxWorkingHrsPerMonth()
                && employee.getTotalNoOfEmpWorkingDays() < company.getTotalNoOfWorkingDays()) {
            if (employee.isPresent()) {
                day++;
                switch (employee.getEmployeeType()) {
                    case FULL_TIME:
                        if (employee.getEmpHrs() + FUL_TIME_HRS > company.getMaxWorkingHrsPerMonth()) {
                            company.getDailyWage().put(day, (company.getMaxWorkingHrsPerMonth() - employee.getEmpHrs()) * company.getWagePerHr());
                            employee.setEmpHrs(company.getMaxWorkingHrsPerMonth());
                        } else {
                            employee.setEmpHrs(employee.getEmpHrs() + FUL_TIME_HRS);
                            company.getDailyWage().put(day, FUL_TIME_HRS * company.getWagePerHr());
                        }
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
    public Company readEmployeeDetails(Scanner scanner) {
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

    @Override
    public int getTotalWage(String companyName) {
        for(Company company : companyList) {
            if (company.getCompanyName().equals(companyName)) {
                return company.getTotalEmployeeWage();
            }
        }
        return 0;
    }
}

