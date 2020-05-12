package backend.service;

import backend.model.TestModel;
import org.springframework.stereotype.Service;
import backend.service.serviceInterface.TestService;

@Service
public class TestServiceImpl implements TestService {

    public String test(){
        return "Test Method";
    }

}
