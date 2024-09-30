package ee.ivkhkdev;

import ee.ivkhkdev.interfaces.Input;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.management.StringValueExp;
import java.io.*;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class AppTest {
    InputStream inputMock;
    InputStream defaultIn;
    OutputStream defaultOut;
    @BeforeEach
    void setUp() {
        defaultIn = System.in;
        defaultOut = System.out;
        inputMock = Mockito.mock(Input.class);
    }

    @AfterEach
    void tearDown() {

        System.setIn(defaultIn);
        System.setOut((PrintStream) defaultOut);
    }
    @Test
    public void testRunExit() {
        when(inputMock.read()).thenReturn(0);
        String input = "0\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        App app = new App();
        app.run();
        String output = out.toString();
        assertTrue(output.contains("До свидания!"));
    }
    @Test
    public void testRunTask1() {

        String input = "1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        App app = new App();
        app.run();
        String output = out.toString();
        assertTrue(output.contains("Добавление пользователя"));
    }
    @Test
    public void testRunInvalidInput() {
        String input = "\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        App app = new App();
        app.run();
        String output = out.toString();
        assertTrue(output.contains("Добавление пользователя"));
    }
}