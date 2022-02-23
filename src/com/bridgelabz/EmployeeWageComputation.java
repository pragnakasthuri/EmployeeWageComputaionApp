/**
 * Check Employee is Present or Absent
 */
package com.bridgelabz;

public class EmployeeWageComputation {
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");
        System.out.println("Check Employee is Present or Absent");
        /**
         * passing values through constructor and calculating employee daily wage
         */
        Employee employee = new Employee(EmployeeType.FULL_TIME, 8, 20);
        System.out.println("Employee is "+(employee.isPresent() ? "Present" : "Absent"));

        System.out.println("Employee Daily Wage: "+employee.getEmpHrs() * employee.getWagePerHr());
    }
}