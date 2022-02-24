/**
 * Calculate employee Wage for multiple companies
 */
package com.bridgelabz;

import java.util.Scanner;

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
        Employee employee = readEmployeeDetails(scanner);

        while (employee.getEmpHrs() <= employee.getMaxHoursPerMonth()
                && employee.getTotalNoOfEmpWorkingDays() < employee.getNoOfWorkingDaysPerMonth() ){
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
        System.out.println("Employee working days and hours are: "+employee.getTotalNoOfEmpWorkingDays()+","+employee.getEmpHrs());
        System.out.println("Employee Monthly Wage : " + employee.getEmpHrs() * employee.getWagePerHr());
    }

    /**
     * @param scanner
     * @return The values given by the user as employee object
     */
    public static Employee readEmployeeDetails(Scanner scanner) {
        Employee employee = new Employee();

        System.out.println("Enter company");
        employee.setCompany(scanner.next());
        System.out.println("Enter Max working days");
        employee.setNoOfWorkingDaysPerMonth(scanner.nextInt());
        System.out.println("Enter Max working hours");
        employee.setMaxHoursPerMonth(scanner.nextInt());
        System.out.println("Enter wage per hour");
        employee.setWagePerHr(scanner.nextInt());
        System.out.println("Enter employee type: \n1. Full Time\n2. Part Time");
        int employeeType = scanner.nextInt();
        scanner.close();
        employee.setEmployeeType(employeeType == 1 ? EmployeeType.FULL_TIME : EmployeeType.PART_TIME);

        return employee;
    }
}

