package ee.ivkhkdev.services;

import ee.ivkhkdev.App;
import ee.ivkhkdev.interfaces.EmployeeProvider;
import ee.ivkhkdev.interfaces.Input;
import ee.ivkhkdev.model.Employee;

public class EmployeeService {
    private final EmployeeProvider employeeProvider;

    public EmployeeService(EmployeeProvider employeeProvider) {
        this.employeeProvider = employeeProvider;

    }

    public boolean createEmployee(Input input) {
        Employee employee = employeeProvider.addEmployee(input);
        for (int i = 0; i < App.employees.length; i++) {
            if (i == 0 && App.employees[i] == null) {
                App.employees[i] = employee;
                return true;
            }
            else if (i > 0 && App.employees[i] == null) {
                App.employees[i] = employee;
                return true;
            }
        }
        return false;
    }

    public void printEmployee(Input input) {
        boolean hasEmployees = false;
        for (int i = 0; i < App.employees.length; i++) {
            if (App.employees[i] != null) {
                System.out.println(App.employees[i]);
                hasEmployees = true;
            }
        }

        if (!hasEmployees) {
            System.out.println("Список сотрудников пуст.");
        }
    }
}
