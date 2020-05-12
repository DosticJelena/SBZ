package backend.service;

import backend.repository.AllergenRepository;
import backend.service.serviceInterface.AllergenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AllergenServiceImpl implements AllergenService {

    @Autowired
    private AllergenRepository allergenRepository;

}
