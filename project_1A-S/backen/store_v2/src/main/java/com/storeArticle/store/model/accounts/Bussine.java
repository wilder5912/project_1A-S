
package com.storeArticle.store.model.accounts;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="bussine")
public class Bussine implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="bussine_id", nullable = false, updatable = false)
    private int bussineId;


    @Column(name="name_bu", nullable = false, updatable = false)
    private String nameBu;

    public int getBussineId() {
        return bussineId;
    }

    public void setBussineId(int bussineId) {
        this.bussineId = bussineId;
    }

    public String getNameBu() {
        return nameBu;
    }

    public void setNameBu(String nameBu) {
        this.nameBu = nameBu;
    }

}
