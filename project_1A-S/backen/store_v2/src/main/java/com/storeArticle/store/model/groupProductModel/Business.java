
package com.storeArticle.store.model.groupProductModel;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="business")
public class Business implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "business_id")
    private int businessId;


    @Column(name = "name_bu" )
    private String nameBu;

    @Column(name = "is_delete_bu")
    private boolean isDelete;

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

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
