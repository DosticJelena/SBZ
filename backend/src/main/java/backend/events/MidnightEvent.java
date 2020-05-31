package backend.events;

import backend.kie.util.KnowledgeSessionHelper;
import backend.model.UserModel;
import backend.repository.UserRepository;
import lombok.Getter;
import lombok.Setter;
import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Role(Role.Type.EVENT)
@Timestamp("executionTime")
@Expires("5m")
public class MidnightEvent implements Serializable {
    private static final long serialVersionUID = 1L;
    private Date executionTime;


    public MidnightEvent() {
        super();
        this.executionTime = new Date();

    }

}
