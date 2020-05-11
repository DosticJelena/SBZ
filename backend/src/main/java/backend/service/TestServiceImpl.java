package backend.service;

import org.springframework.stereotype.Service;
import backend.service.serviceInterface.TestService;

@Service
public class TestServiceImpl implements TestService {

    public String test(){
        return "Test Method";
    }

}
