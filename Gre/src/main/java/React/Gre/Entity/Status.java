package React.Gre.Entity;

import javax.persistence.*;

@Entity(name = "status")
@Table(name = "status")
public class Status{

    @EmbeddedId
    private Token tokenid;

    public Status(Token tokenid) {
        this.tokenid = tokenid;
    }

    public Token getTokenid() {
        return tokenid;
    }

    public void setTokenid(Token tokenid) {
        this.tokenid = tokenid;
    }

    public Status() {
    }

}
