package test.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idbranch;
    private String namebranch;

    public Branch() {
    }

    public Branch(long idbranch, String namebranch) {
        this.idbranch = idbranch;
        this.namebranch = namebranch;
    }

    public long getIdbranch() {
        return idbranch;
    }

    public void setIdbranch(long idbranch) {
        this.idbranch = idbranch;
    }

    public String getNamebranch() {
        return namebranch;
    }

    public void setNamebranch(String namebranch) {
        this.namebranch = namebranch;
    }
}
