package backend.service.serviceInterface;

import backend.model.Macronutrients;

import java.util.List;

public interface MacronutrientsService {
        Macronutrients findById(long id);
        Macronutrients findByUserId(long userId);
        List<Macronutrients> findAll();

        Macronutrients save(Macronutrients macronutrients);

        void deleteById(long id);
}
