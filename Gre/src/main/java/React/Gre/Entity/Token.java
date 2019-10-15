package React.Gre.Entity;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Token implements Serializable {

    private int u_id;
    private int w_id;
    public int getU_id() {
        return u_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token = (Token) o;
        return u_id == token.u_id &&
                w_id == token.w_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(u_id, w_id);
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public int getW_id() {
        return w_id;
    }

    public void setW_id(int w_id) {
        this.w_id = w_id;
    }

    public Token() {
    }

    public Token(int u_id, int w_id) {
        this.u_id = u_id;
        this.w_id = w_id;
    }
}