package backend.service;

import backend.model.Macronutrients;
import backend.repository.MacronutrientsRepository;
import backend.service.serviceInterface.MacronutrientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MacronutrientsServiceImpl implements MacronutrientsService {

    @Autowired
    private MacronutrientsRepository macronutrientsRepository;

    @Override
    public Macronutrients findById(long id){
        return macronutrientsRepository.findById(id);
    }

    @Override
    public Macronutrients findByUserId(long userId) {
        return macronutrientsRepository.findByUserId(userId);
    }

    @Override
    public List<Macronutrients> findAll(){
        return macronutrientsRepository.findAll();
    }

    @Override
    public Macronutrients save(Macronutrients macronutrients){
        return macronutrientsRepository.save(macronutrients);
    }

    @Override
    public void deleteById(long id){
        macronutrientsRepository.deleteById(id);
    }

}
