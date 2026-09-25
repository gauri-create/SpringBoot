package com.example.CircularDependencyDemo.Simple;

/**
 * A
 */
public class A {

    private B b;

    public A(){
        System.out.println("A created");
        this.b = new B();
    }
}
