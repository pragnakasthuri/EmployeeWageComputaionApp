/**
 * Check Employee is Present or Absent
 */
package com.bridgelabz;

public class EmployeeWageComputation {
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");
        System.out.println("Check Employee is Present or Absent");
        Employee employee = new Employee();
        System.out.println("Employee is "+(employee.isPresent() ? "Present" : "Absent"));
    }
}