package org.example.Controller;

import org.example.Service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/User")
public class UserController {
    private UserService useerservice;

    public UserController(UserService userservice){
        this.useerservice = userservice;
    }

    @GetMapping("/query")
    public String sayQueryService(@RequestParam String name){
        String context = useerservice.toservice(name);
        return context;
    }
    @GetMapping("/param/{name}")
    public String sayHelloPath(@PathVariable String name) {
        return useerservice.getGreeting(name);
    }
    @PutMapping("/put/{firstName}")
    public String sayHelloPut(@PathVariable String firstName,
                              @RequestParam String lastName) {
        return useerservice.getGreeting(firstName, lastName);
    }
}
