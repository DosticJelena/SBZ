package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import service.serviceInterface.TestService;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping(value="/test")
    public String test(){
        return testService.test();
    }

}
