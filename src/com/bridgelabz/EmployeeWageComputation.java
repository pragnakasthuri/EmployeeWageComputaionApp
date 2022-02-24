package com.bridgelabz;

public class EmployeeWageComputation {
    /**
     * Declaring constants
     */
    private static final int MAX_NUM_OF_HRS = 100;
    private static final int FUL_TIME_HRS = 8;
    private static final int PART_TIME_HRS = 4;
    private static final int WAGE_PER_HR = 20;
    private static final int MAX_NO_OF_WORKING_DAYS = 20;

    public static void main(String[] args) {
        Employee employee = new Employee(EmployeeType.FULL_TIME, 0, 20);
        computeAndPrintEmployeeWage(employee);
    }

    /**
     * @param employee and prints the employee monthly wage based on condition
     */
    private static void computeAndPrintEmployeeWage(Employee employee) {
        while (employee.getEmpHrs() <= MAX_NUM_OF_HRS && employee.getTotalNoOfWorkingDays() <= MAX_NO_OF_WORKING_DAYS ){
            if (employee.isPresent()) {
                switch (employee.getEmployeeType()) {
                    case FULL_TIME:
                        employee.setEmpHrs(employee.getEmpHrs() + FUL_TIME_HRS);
                        if (employee.getEmpHrs() > 100) {
                            employee.setEmpHrs(100);
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
        System.out.println("Employee Monthly Wage : " + employee.getEmpHrs() * WAGE_PER_HR);
    }
}
