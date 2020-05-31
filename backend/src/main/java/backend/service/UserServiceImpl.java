package backend.service;

import backend.kie.util.KnowledgeSessionHelper;
import backend.model.DailyStatus;
import backend.model.UserModel;
import backend.model.Macronutrients;
import backend.repository.DailyStatusRepository;
import backend.repository.UserRepository;
import backend.service.serviceInterface.UserService;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DailyStatusRepository dailyStatusRepository;

    @Override
    public UserModel findById(long id){
        return userRepository.findById(id);
    }

    @Override
    public UserModel findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    @Override
    public List<UserModel> findAll(){
        return userRepository.findAll();
    }

    @Override
    public List<DailyStatus> findAllDailyStatuses(long id) {
       return dailyStatusRepository.findByUserId(id);
    }

    @Override
    public UserModel save(UserModel userModel){
        KieContainer kc = KnowledgeSessionHelper.createRuleBase();
        KieSession kSession = KnowledgeSessionHelper.getStatefulKnowledgeSession(kc, "user-rules");

        if(userModel.getMacros() == null){
            userModel.setMacros(new Macronutrients());
        }

        kSession.insert(userModel);

        kSession.getAgenda().getAgendaGroup("calorieCalculator").setFocus();
        kSession.fireAllRules();
        return userRepository.save(userModel);
    }

    @Override
    public void deleteById(long id){
        userRepository.deleteById(id);
    }

}
