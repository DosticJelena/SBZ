package backend.service;

import backend.repository.MacronutrientsRepository;
import backend.service.serviceInterface.MacronutrientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MacronutrientsServiceImpl implements MacronutrientsService {

    @Autowired
    private MacronutrientsRepository macronutrientsRepository;

}
