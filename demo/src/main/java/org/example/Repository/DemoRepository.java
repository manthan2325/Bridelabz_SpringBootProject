package org.example.Repository;

import org.springframework.stereotype.Repository;

@Repository
public class DemoRepository {

    public String getStudentName(String message){
        return "Hey Manthan";
    }
    public void forwardMessage(String message){
        System.out.println("The message is" + message);
        System.out.println("message created");
    }
    public String gotoRepo(String name){
        return "Hello" + name;
    }
    public String torepoPath(String name){
        return name;
    }
}
