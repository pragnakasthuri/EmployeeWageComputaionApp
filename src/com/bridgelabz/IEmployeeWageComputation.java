package com.bridgelabz;

import java.util.Scanner;

public interface IEmployeeWageComputation {
    public Company readEmployeeDetails(Scanner scanner);
    public int calculateEmployeeWage(Company company);
    public int getTotalWage(String companyName);
}
