package ee.ivkhkdev;

import ee.ivkhkdev.interfaces.EmployeeProvider;
import ee.ivkhkdev.interfaces.EmployeeRepository;
import ee.ivkhkdev.interfaces.Input;
import ee.ivkhkdev.interfaces.impl.EmployeeFileService;
import ee.ivkhkdev.interfaces.impl.InputEmployee;
import ee.ivkhkdev.interfaces.impl.ConsoleInput;
import ee.ivkhkdev.services.EmployeeService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        EmployeeProvider employeeProvider = new InputEmployee();
        EmployeeService employeeService = new EmployeeService(employeeProvider);
        EmployeeRepository employeeRepository = new EmployeeFileService();
        App app = new App(input, employeeService, employeeRepository);
        app.run();
    }
}