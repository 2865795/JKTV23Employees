package ee.ivkhkdev.interfaces.impl;

import ee.ivkhkdev.App;
import ee.ivkhkdev.interfaces.EmployeeProvider;
import ee.ivkhkdev.model.Address;
import ee.ivkhkdev.model.Employee;
import ee.ivkhkdev.interfaces.Input;
import ee.ivkhkdev.model.Person;


public class InputEmployee implements EmployeeProvider {
    @Override
    public Employee addEmployee(Input input) {

        Person person = new Person();
        Address address = new Address();
        Employee employee = new Employee();

        System.out.println("Новый сотрудник ");
        System.out.print("Имя: ");
        person.setFirstname(input.nextLine());

        System.out.print("Фамилия: ");
        person.setLastname(input.nextLine());

        System.out.print("Должность: ");
        employee.setPosition(input.nextLine());

        System.out.print("Зарплата: ");
        employee.setSalary(input.nextLine());

        System.out.print("Город: ");
        address.setCity(input.nextLine());

        System.out.print("Улица: ");
        address.setStreet(input.nextLine());

        System.out.print("Дом: ");
        address.setHouse(input.nextLine());

        System.out.print("Квартира: ");
        address.setApartment(input.nextLine());

        person.setAddress(address);
        employee.setPerson(person);

        return employee;
    }

    @Override
    public void listEmployees() {
        boolean hasEmployees = false;
        for (int i=0; i < App.employees.length;i++){
            Employee employee = App.employees[i];
            if(employee != null){
                System.out.printf("%d. %s %s%n %s%n %s%n",
                        i+1,
                        employee.getPerson().getFirstname(),
                        employee.getPerson().getLastname(),
                        employee.getPosition(),
                        employee.getSalary());
                hasEmployees = true;
            }
            if (!hasEmployees) {
                System.out.println("Список сотрудников пуст.");
            }
        }
    }
}
