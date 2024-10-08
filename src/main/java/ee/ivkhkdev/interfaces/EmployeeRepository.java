package ee.ivkhkdev.interfaces;

import ee.ivkhkdev.model.Employee;

public interface EmployeeRepository {
    boolean saveEmployees(Employee[] employees);
    Employee[] loadEmployees();
}
