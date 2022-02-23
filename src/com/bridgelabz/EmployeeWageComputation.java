/**
 * Calculate Part Time  and full time employee wage using switch case
 */
package com.bridgelabz;

public class EmployeeWageComputation {
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");

        /**
         * passing values through constructor and calculating employee daily wage
         */
        Employee fullTimeEmployee = new Employee(EmployeeType.FULL_TIME, 8, 20);
        Employee partTimeEmployee = new Employee(EmployeeType.PART_TIME, 4, 20);
        /**
         * Using switch case to calculate full time and parttime employee wage
         */
        switch (fullTimeEmployee.getEmployeeType()) {
            case FULL_TIME:
                System.out.println("Full time Employee Daily Wage : " + fullTimeEmployee.getEmpHrs() * fullTimeEmployee.getWagePerHr());
                break;
            case PART_TIME:
                System.out.println("Part time Employee Daily Wage : " + partTimeEmployee.getEmpHrs() * partTimeEmployee.getWagePerHr());
                break;
            default:
                System.out.println("Invalid employee type!");
        }
    }
}
