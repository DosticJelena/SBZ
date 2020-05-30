package backend.controller.scheduled;


import backend.events.MidnightEvent;
import backend.kie.util.KnowledgeSessionHelper;
import backend.model.UserModel;
import backend.repository.UserRepository;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class ScheduledTasks {
    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);


    @Autowired
    private UserRepository userRepository;

    @Scheduled(cron = "30 * * * * *")
    public void struckMidnight(){

        KieContainer kc = KnowledgeSessionHelper.createRuleBase();
        KieSession kSession = KnowledgeSessionHelper.getStatefulKnowledgeSession(kc, "cep-rules");
        for(UserModel u: userRepository.findAll())
            kSession.insert(u);

        kSession.getAgenda().getAgendaGroup("midnight-events").setFocus();
        kSession.insert(new MidnightEvent());
        kSession.fireAllRules();
        logger.info("MIDNIGHT");
    }
}
