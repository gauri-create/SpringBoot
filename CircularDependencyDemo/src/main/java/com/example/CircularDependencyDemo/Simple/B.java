package com.example.CircularDependencyDemo.Simple;

public class B {
    private A a; 

    // public B(A a){
    //     this.a=a;
    // }

    public B(){
        System.out.println("B created");
        this.a=new A();
    }
}
