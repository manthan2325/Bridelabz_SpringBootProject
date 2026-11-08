package org.example.Controller;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import org.example.Service.DemoService;
import org.example.entity.MessageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/demo")
public class DemoController {

    private DemoService demoService;

    public DemoController(DemoService demoService){
        this.demoService = demoService;
    }

    @GetMapping("/get")
    public String getDetails(@RequestBody MessageRequest request){
        String messages = demoService.getReply(request.getMessage());
        return messages;
    }
    @PostMapping("/create")
    public ResponseEntity<String> sendMessage(@RequestBody MessageRequest request){
        demoService.receiveMessage(request.getMessage());
        return ResponseEntity.status(HttpStatus.CREATED).body("done");
    }
    @GetMapping("/getName")
    public ResponseEntity<String> getName(@RequestParam String name){
        String message = demoService.goToService(name);
        return ResponseEntity.status(HttpStatus.CREATED).body(message);
    }
    @GetMapping("/getPathName/{name}")
    public ResponseEntity<String> getPathName(@PathVariable String name){
        String context = demoService.toservicePath(name);
        return ResponseEntity.status(HttpStatus.OK).body(context);
    }
}
