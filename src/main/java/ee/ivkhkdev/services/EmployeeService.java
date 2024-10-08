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

    public boolean printListEmployees(Input input) {
        employeeProvider.listEmployees();
        return true;
    }
}
