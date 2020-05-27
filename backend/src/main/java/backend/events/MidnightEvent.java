package backend.events;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;

import java.io.Serializable;
import java.util.Date;

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
