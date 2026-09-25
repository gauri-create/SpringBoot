package com.example.XMLBasedConfigDemo;

import java.util.List;
import java.util.Map;

//prototype scope
public class UserService {

    // private Map<Integer, String> username;

    // public UserService(Map<Integer,String> username){
    //     this.username=username;
    //     // System.out.println("UserService created");
    // }

    // public Map<Integer,String> getUsername(){
    //     return username;
    // }

    public UserService(){
        System.out.println("UserService created");
    }

    public void init(){
        System.out.println("Post construct phase");
    }

    public void cleanup(){
        System.out.println("Pre Destroy phase");
    }
}
