package com.bridgelabz;

import java.util.Random;

/**
 * Employee class to deal with employee related data
 */
public class Employee {
    private EmployeeType employeeType;
    private int empHrs;
    private int totalNoOfEmpWorkingDays;
    private String company;

    Employee(EmployeeType employeeType, int empHrs) {
        this.employeeType = employeeType;
        this.empHrs = empHrs;
    }

    /**
     * Non parameterised construction
     */
    Employee() {

    }

    public int getEmpHrs() {
        return empHrs;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public int getTotalNoOfEmpWorkingDays() {
        return totalNoOfEmpWorkingDays;
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


    public void setTotalNoOfEmpWorkingDays(int totalNoOfEmpWorkingDays) {
        this.totalNoOfEmpWorkingDays = totalNoOfEmpWorkingDays;
    }

    public String getCompany() {
        return company;
    }
}

