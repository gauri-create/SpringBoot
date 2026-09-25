package com.example.SevletCrudDemo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.SevletCrudDemo.model.User;

public class UserService {
    
    private  Map<Integer, User> userDB = new HashMap<>();
    
    public UserService(){
        this.userDB=new HashMap<>();
    }

    public User createdUser(User userReq) {
       userDB.put(userReq.getId(), userReq);
       return userReq;
    }

    public User getUserById(Integer id) {
        return userDB.getOrDefault(id, null);
    }

    public List<User> getAllusers() {
        return new ArrayList<>(userDB.values()) ;
    }


}
