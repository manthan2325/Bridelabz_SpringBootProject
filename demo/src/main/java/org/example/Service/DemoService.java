package org.example.Service;

import org.apache.coyote.Response;
import org.example.Repository.DemoRepository;
import org.example.entity.MessageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service

public class DemoService {
    private DemoRepository demoRepository;

    public DemoService(DemoRepository demoRepository){
        this.demoRepository = demoRepository;
    }
    public String getReply(String message){
        String content = demoRepository.getStudentName(message);
        return content;
    }
    public String receiveMessage(String message){
        if(message.isEmpty()){
            return "Empty String";
        }
        demoRepository.forwardMessage(message);
        return "Done";
    }
    public String goToService(String name){
        String message = demoRepository.gotoRepo(name);
        return message;
    }
    public String toservicePath(String name){
        String a = demoRepository.torepoPath(name);
        return a;
    }
}
