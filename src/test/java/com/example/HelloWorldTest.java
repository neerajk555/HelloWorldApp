package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class HelloWorldTest {
    
    @Test
    public void testGetMessage() {
        HelloWorld app = new HelloWorld();
        String message = app.getMessage();
        assertNotNull(message);
        assertTrue(message.contains("Hello, World!"));
    }
    
    @Test
    public void testAdd() {
        HelloWorld app = new HelloWorld();
        assertEquals(5, app.add(2, 3));
    }
}
