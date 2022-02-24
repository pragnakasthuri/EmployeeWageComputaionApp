package com.bridgelabz;

import java.util.Random;

/**
 * Employee class to deal with employee related data
 */
public class Employee {
    private EmployeeType employeeType;
    private int empHrs;
    private int wagePerHr;
    private int maxHoursPerMonth;
    private int noOfWorkingDaysPerMonth;
    private int totalNoOfEmpWorkingDays;
    private String company;

    Employee(EmployeeType employeeType, int empHrs, int wagePerHr) {
        this.employeeType = employeeType;
        this.empHrs = empHrs;
        this.wagePerHr = wagePerHr;
    }

    /**
     * Non parameterised construction
     */
    Employee() {

    }

    public int getEmpHrs() {
        return empHrs;
    }

    public int getWagePerHr() {
        return wagePerHr;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public int getTotalNoOfEmpWorkingDays() {
        return totalNoOfEmpWorkingDays;
    }

    public void setEmpHrs(int empHrs) {
        this.empHrs = empHrs;
        if (this.empHrs > this.maxHoursPerMonth) {
            this.empHrs = this.maxHoursPerMonth;
        }
    }

    /**
     * This method will check whether the given employee is prent or absent
     * @return true if employee is present, false otherwise
     */
    public boolean isPresent() {
        Random random = new Random();
        int isPresent = random.nextInt(2);
        if (isPresent == 1) {
            this.totalNoOfEmpWorkingDays++;
            return true;
        }
        return false;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public void setWagePerHr(int wagePerHr) {
        this.wagePerHr = wagePerHr;
    }

    public int getMaxHoursPerMonth() {
        return maxHoursPerMonth;
    }

    public void setMaxHoursPerMonth(int maxHoursPerMonth) {
        this.maxHoursPerMonth = maxHoursPerMonth;
    }

    public int getNoOfWorkingDaysPerMonth() {
        return noOfWorkingDaysPerMonth;
    }

    public void setNoOfWorkingDaysPerMonth(int noOfWorkingDaysPerMonth) {
        this.noOfWorkingDaysPerMonth = noOfWorkingDaysPerMonth;
    }

    public void setTotalNoOfEmpWorkingDays(int totalNoOfEmpWorkingDays) {
        this.totalNoOfEmpWorkingDays = totalNoOfEmpWorkingDays;
    }

    public String getCompany() {
        return company;
    }
}

