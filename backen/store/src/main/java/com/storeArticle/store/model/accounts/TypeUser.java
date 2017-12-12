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
@Table(name="typeuser")
public class TypeUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="type_user_id")
    private int typeUserID;
    @Column(name="name_type")
    private String nameType;

    public int getTypeUserID() {
        return typeUserID;
    }
    public void setTypeUserID(int typeUserID) {
        this.typeUserID = typeUserID;
    }
    public String getAmeType() {
        return nameType;
    }
    public void setAmeType(String nameType) {
        this.nameType = nameType;
    }


}
