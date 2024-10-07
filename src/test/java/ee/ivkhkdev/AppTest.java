package ee.ivkhkdev;

import ee.ivkhkdev.interfaces.Input;
import ee.ivkhkdev.interfaces.impl.ConsoleInput;
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
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(out));
        when(mockInput.nextLine()).thenReturn("0");
        App app = new App(mockInput);
        app.run();
        String actualOut = mockOut.toString();
        System.setOut(new PrintStream(defaultOut));
        System.out.println(mockOut.toString());
        String expectedOutFragment = "До свидания!";
        assertTrue(actualOut.contains(expectedOutFragment));
    }
   // @Test
    public void testRunTask1() {

        String input = "1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        App app = new App(mockInput);
        app.run();
        String output = out.toString();
        assertTrue(output.contains("Добавление пользователя"));
    }
    // @Test
    public void testRunInvalidInput() {
        String input = "\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        App app = new App(mockInput);
        app.run();
        String output = out.toString();
        assertTrue(output.contains("Добавление пользователя"));
    }
}