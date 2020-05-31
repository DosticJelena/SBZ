package backend.controller.scheduled;


import backend.events.MidnightEvent;
import backend.kie.util.KnowledgeSessionHelper;
import backend.model.DailyStatus;
import backend.model.Macronutrients;
import backend.model.UserModel;
import backend.repository.DailyStatusRepository;
import backend.repository.UserRepository;
import org.apache.catalina.User;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


@Component
public class ScheduledTasks {
    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DailyStatusRepository dailyStatusRepository;

    @Scheduled(cron = "30 * * * * *")
    public void struckMidnight(){
//
        KieContainer kc = KnowledgeSessionHelper.createRuleBase();
        KieSession kSession = KnowledgeSessionHelper.getStatefulKnowledgeSession(kc, "cep-rules");
        List<UserModel> userModels= new ArrayList<UserModel>();
        for(UserModel u: userRepository.findAll()){
            DailyStatus ds = new DailyStatus();
            ds.setDate(new Timestamp(System.currentTimeMillis()));
            ds.setMacros(new Macronutrients());
            u.getDailyStatuses().add(ds);
            userRepository.save(u);
            kSession.insert(u);
        }


        kSession.getAgenda().getAgendaGroup("midnight-events").setFocus();
        kSession.insert(new MidnightEvent());
        kSession.fireAllRules();

        for(UserModel u: userModels)
            userRepository.save(u);
    }
}
