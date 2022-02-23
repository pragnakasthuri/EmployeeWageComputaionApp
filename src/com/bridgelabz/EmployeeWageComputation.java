/**
 * calculate monthly wage
 */
package com.bridgelabz;

public class EmployeeWageComputation {
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");

        /**
         * passing values through constructor and calculating employee monthly wage
         */
        Employee fullTimeEmployee = new Employee(EmployeeType.FULL_TIME, 8, 20);
        int monthlyWage = 0;
        for (int i = 1; i <= 20; i++) {
            if (fullTimeEmployee.isPresent()) {
                monthlyWage += (fullTimeEmployee.getEmpHrs() * fullTimeEmployee.getWagePerHr());
            }
        }
        System.out.println("Employee Monthly wage: $" + monthlyWage);
    }
}
