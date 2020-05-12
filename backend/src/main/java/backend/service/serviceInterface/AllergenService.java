package backend.service.serviceInterface;

import backend.model.Allergen;

import java.util.List;

public interface AllergenService {
    public Allergen findById(long id);
    public Allergen findByName(String name);
    public List<Allergen> findAll();

    public Allergen save(Allergen allergen);

    public void deleteById(long id);
}
