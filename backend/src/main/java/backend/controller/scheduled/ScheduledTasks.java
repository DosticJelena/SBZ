package backend.controller.scheduled;


import backend.events.MidnightEvent;
import backend.kie.util.KnowledgeSessionHelper;
import backend.model.DailyStatus;
import backend.model.Macronutrients;
import backend.model.UserModel;
import backend.model.enumeration.GoodBadStatus;
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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Component
public class ScheduledTasks {
    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DailyStatusRepository dailyStatusRepository;

    @Scheduled(cron = "0 0 0 * * *")
    public void struckMidnight(){

        KieContainer kc = KnowledgeSessionHelper.createRuleBase();
        KieSession kSession = KnowledgeSessionHelper.getStatefulKnowledgeSession(kc, "cep-rules");
        List<UserModel> userModels= new ArrayList<UserModel>();
        for(UserModel u: userRepository.findAll()){
            DailyStatus ds = new DailyStatus();
            ds.setStatus(GoodBadStatus.OKAY);
            ds.setDate(new Timestamp(System.currentTimeMillis()).toLocalDateTime());
            ds.setMacros(new Macronutrients());
            ds.setUser(u);
            dailyStatusRepository.save(ds);
            userModels.add(u);
        }

        for(UserModel u: userModels){
            kSession.insert(u);
        }
        Timestamp tms = new Timestamp(System.currentTimeMillis());
        LocalDate today = tms.toLocalDateTime().toLocalDate();
        kSession.setGlobal("yesterday",today.minusDays(1));

        kSession.getAgenda().getAgendaGroup("midnight-events").setFocus();
        kSession.insert(new MidnightEvent());
        kSession.fireAllRules();

        for(UserModel u: userModels) {
            userRepository.save(u);
        }
    }
}
