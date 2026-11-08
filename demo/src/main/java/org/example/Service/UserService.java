package org.example.Service;

import org.example.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userrepository;

    public UserService(UserRepository userrepository){
        this.userrepository = userrepository;
    }
    public String toservice(String name){
        String con = userrepository.torepo(name);
        return con;
    }
    public String getGreeting(String name) {
        return "Hello " + name + " from BridgeLabz";
    }
    public String getGreeting(String firstName, String lastName) {
        return "Hello " + firstName + " " + lastName + " from BridgeLabz";
    }
}
