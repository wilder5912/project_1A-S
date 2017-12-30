
package com.storeArticle.store.model.accounts;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="bussine")
public class Bussine implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="bussine_id", nullable = false, updatable = false)
    private int bussineId;


    @Column(name="nombre_bu", nullable = false, updatable = false)
    private String nombreBu;

    public int getBussineId() {
        return bussineId;
    }

    public void setBussineId(int bussineId) {
        this.bussineId = bussineId;
    }

    public String getNombreBu() {
        return nombreBu;
    }

    public void setNombreBu(String nombreBu) {
        this.nombreBu = nombreBu;
    }

}
