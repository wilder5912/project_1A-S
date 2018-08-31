package com.storeArticle.store.model.cashierModel;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "authorizationnumber")
public class AuthorizationNumber implements Serializable {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "authorizationnumber_id")
    private int authorizationNumberId;

    @Column(name = "code_authorizationnumbe")
    private String codeAuthorizationNumbe;

    @Column(name = "date_authorizationnumbe")
    private String dateAuthorizationNumbe;

    @Column(name = "is_delete_authorizationnumbe")
    private boolean isDelete;

    public int getAuthorizationNumberId() {
        return authorizationNumberId;
    }

    public void setAuthorizationNumberId(int authorizationNumberId) {
        this.authorizationNumberId = authorizationNumberId;
    }

    public String getCodeAuthorizationNumbe() {
        return codeAuthorizationNumbe;
    }

    public void setCodeAuthorizationNumbe(String codeAuthorizationNumbe) {
        this.codeAuthorizationNumbe = codeAuthorizationNumbe;
    }

    public String getDateAuthorizationNumbe() {
        return dateAuthorizationNumbe;
    }

    public void setDateAuthorizationNumbe(String dateAuthorizationNumbe) {
        this.dateAuthorizationNumbe = dateAuthorizationNumbe;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
