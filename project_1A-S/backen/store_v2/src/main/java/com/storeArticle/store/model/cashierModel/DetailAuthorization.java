package com.storeArticle.store.model.cashierModel;

import com.storeArticle.store.model.groupProductModel.Business;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "detailauthorization")
public class DetailAuthorization implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "detailauthorization_id")
    private int detailauthorizationId;

    @ManyToOne
    @JoinColumn(name = "authorizationnumber_id")
    private AuthorizationNumber authorizationNumberId;

    @Column(name = "is_delete_detailauthorization")
    private boolean isDelete;

    public int getDetailauthorizationId() {
        return detailauthorizationId;
    }

    public void setDetailauthorizationId(int detailauthorizationId) {
        this.detailauthorizationId = detailauthorizationId;
    }

    public AuthorizationNumber getAuthorizationNumberId() {
        return authorizationNumberId;
    }

    public void setAuthorizationNumberId(AuthorizationNumber authorizationNumberId) {
        this.authorizationNumberId = authorizationNumberId;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
