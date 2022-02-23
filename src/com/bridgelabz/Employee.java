package com.bridgelabz;

import java.util.Random;

/**
 * Employee class to deal with employee related data
 */
public class Employee {
    private EmployeeType employeeType;
    private int empHrs;
    private int wagePerHr;
    private int totalNoOfWorkingDays;

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

    public int getTotalNoOfWorkingDays() {
        return totalNoOfWorkingDays;
    }

    public void setEmpHrs(int empHrs) {
        this.empHrs = empHrs;
    }

    /**
     * This method will check whether the given employee is prent or absent
     * @return true if employee is present, false otherwise
     */
    public boolean isPresent() {
        Random random = new Random();
        int isPresent = random.nextInt(2);
        if (isPresent == 1) {
            this.totalNoOfWorkingDays++;
            return true;
        }
        return false;
    }
}

