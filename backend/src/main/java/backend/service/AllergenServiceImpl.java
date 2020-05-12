package backend.service;

import backend.model.Allergen;
import backend.repository.AllergenRepository;
import backend.service.serviceInterface.AllergenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllergenServiceImpl implements AllergenService {

    @Autowired
    private AllergenRepository allergenRepository;

    @Override
    public Allergen findById(long id){
        return allergenRepository.findById(id);
    }
    @Override
    public Allergen findByName(String name){
        return allergenRepository.findByName(name);
    }

    public List<Allergen> findAll(){
        List<Allergen> result = allergenRepository.findAll();
        return result;
    }

    @Override
    public Allergen save(Allergen allergen){
        return allergenRepository.save(allergen);
    }

    @Override
    public void deleteById(long id){
        allergenRepository.deleteById(id);
    }

}
