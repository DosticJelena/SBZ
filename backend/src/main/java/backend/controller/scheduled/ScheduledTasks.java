package backend.controller.scheduled;


import backend.events.MidnightEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class ScheduledTasks {
    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

    @Scheduled(cron = "0 0 0 * * *")
    public void struckMidnight(){
        new MidnightEvent();
        logger.info("MIDNIGHT");
    }
}
