package com.example;

/**
 * Simple Hello World Application
 */
public class HelloWorld {
    
    public static void main(String[] args) {
        HelloWorld app = new HelloWorld();
        System.out.println(app.getMessage());
    }
    
    public String getMessage() {
        return "Hello, World! This is a Jenkins CI/CD Example.";
    }
    
    public int add(int a, int b) {
        return a + b;
    }
}
