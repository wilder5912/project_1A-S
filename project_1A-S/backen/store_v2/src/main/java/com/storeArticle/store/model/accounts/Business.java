
package com.storeArticle.store.model.accounts;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="business")
public class Business implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="business_id", nullable = false, updatable = false)
    private int businessId;


    @Column(name="name_bu", nullable = false, updatable = false)
    private String nameBu;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getBusinessId() {
        return businessId;
    }

    public void setBusinessId(int businessId) {
        this.businessId = businessId;
    }

    public String getNameBu() {
        return nameBu;
    }

    public void setNameBu(String nameBu) {
        this.nameBu = nameBu;
    }

}
