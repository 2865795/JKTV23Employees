package ee.ivkhkdev.interfaces.impl;

import ee.ivkhkdev.interfaces.EmployeeRepository;
import ee.ivkhkdev.model.Employee;

import java.io.*;

public class EmployeeFileService implements EmployeeRepository {

    @Override
    public boolean saveEmployees(Employee[] employees) {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("employee");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(employees);
            objectOutputStream.flush();
        } catch (FileNotFoundException e) {
            System.out.println("Нет такого файла: "+e.toString());
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода: "+e.toString());
        }
        return false;
    }

    public Employee[] loadEmployees() {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream("employee");
            objectInputStream = new ObjectInputStream(fileInputStream);
            return (Employee[]) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Нет такого файла: "+e.toString());
        }catch (IOException e) {
            System.out.println("Ошибка ввода/вывода: "+e.toString());
        } catch (ClassNotFoundException e) {
            System.out.println("Нн найден класс: "+e.toString());
        }
        return new Employee[100];
    }
}
