package React.Gre.Entity;

import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "status")
@Table(name = "status")
public class Status{

    @EmbeddedId
    private token tokenid;

    public Status(token tokenid) {
        this.tokenid = tokenid;
    }

    public token getTokenid() {
        return tokenid;
    }

    public void setTokenid(token tokenid) {
        this.tokenid = tokenid;
    }

    public Status() {
    }

}
