package ee.ivkhkdev;

import ee.ivkhkdev.interfaces.EmployeeProvider;
import ee.ivkhkdev.interfaces.Input;
import ee.ivkhkdev.interfaces.InputEmployee;
import ee.ivkhkdev.interfaces.impl.ConsoleInput;
import ee.ivkhkdev.model.Address;
import ee.ivkhkdev.model.Employee;
import ee.ivkhkdev.model.Person;
import ee.ivkhkdev.services.EmployeeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AppTest {
    OutputStream defaultOut;
    ByteArrayOutputStream mockOut;
    Input mockInput;

    @BeforeEach
    void setUp() {
        mockInput = mock(ConsoleInput.class);
        defaultOut = System.out;
        mockOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(mockOut));
    }

    @AfterEach
    void tearDown() {
        System.setOut( new PrintStream(defaultOut));
    }

    @Test
    public void testRunExit() {
        when(mockInput.nextLine()).thenReturn("0");
        App app = new App(mockInput, new EmployeeService(new InputEmployee()));
        app.run();
        String actualOut = mockOut.toString();
        System.setOut(new PrintStream(defaultOut));
        System.out.println(mockOut.toString());
        String expectedOutFragment = "До свидания!";
        assertTrue(actualOut.contains(expectedOutFragment));
    }
    @Test
    public void testRunTask1() {
        when(mockInput.nextLine()).thenReturn("1","0");
        InputEmployee inputEmployeeMock = mock(InputEmployee.class);
        when(inputEmployeeMock.addEmployee(mockInput)).thenReturn(
                new Employee(
                        "Director",
                        "3000",
                        new Person(
                                "Ivan",
                                "Ivanov",
                                new Address(
                                        "Johvi",
                                        "Kooli",
                                        "32",
                                        "3"
                                )
                        )
                )
        );
        App app = new App(mockInput, new EmployeeService(new InputEmployee()));
        app.run();
        String actualOut = mockOut.toString();
        System.setOut(new PrintStream(defaultOut));
        System.out.println(mockOut.toString());
        String expectedOutFragment1 = "Сотрудник добавлен.";
        assertTrue(actualOut.contains(expectedOutFragment1));
        String expectedOutFragment2 = "До свидания!";
        assertTrue(actualOut.contains(expectedOutFragment2));
    }
    @Test
    public void testRunTask2() {
        when(mockInput.nextLine()).thenReturn("1","2", "0");
        InputEmployee inputEmployeeMock = mock(InputEmployee.class);
        when(inputEmployeeMock.addEmployee(mockInput)).thenReturn(
                new Employee(
                        "Director",
                        "3000",
                        new Person(
                                "Ivan",
                                "Ivanov",
                                new Address(
                                        "Johvi",
                                        "Kooli",
                                        "32",
                                        "3"
                                )
                        )
                )
        );
        App app = new App(mockInput, new EmployeeService(new InputEmployee()));
        app.run();
        String actualOut = mockOut.toString();
        System.setOut(new PrintStream(defaultOut));
        System.out.println(mockOut.toString());
        String expectedOutFragment3 = "Список сотрудников: ";
        assertTrue(actualOut.contains(expectedOutFragment3));
    }
    @Test
    public void testRunInvalidInput() {
        when(mockInput.nextLine()).thenReturn("5", "0");
        App app = new App(mockInput, new EmployeeService(new InputEmployee()));
        app.run();
        String actualOut = mockOut.toString();
        System.setOut(new PrintStream(defaultOut));
        System.out.println(mockOut.toString());
        String expectedOutFragment4 = "Выбрана несуществующая задача!";
        assertTrue(actualOut.contains(expectedOutFragment4));
        String expectedOutFragment5 = "До свидания!";
        assertTrue(actualOut.contains(expectedOutFragment5));
    }
}