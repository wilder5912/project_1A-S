package com.storeArticle.store.model.TypeMoneyModel;

import com.storeArticle.store.model.groupProductModel.Business;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "typemoney")
public class TypeMoney implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "typemoney_id")
    private int typeMoneyId;

    @ManyToOne
    @JoinColumn(name = "business_id")
    private Business businessId;

    @Column(name ="name_typemoney")
    private String nameTypeMoney;

    @Column(name = "type_change_typemoney")
    private float typeChangeTypemoney;

    @Column(name = "is_delete_typemoney")
    private boolean isDelete;


    public int getTypeMoneyId() {
        return typeMoneyId;
    }

    public void setTypeMoneyId(int typeMoneyId) {
        this.typeMoneyId = typeMoneyId;
    }

    public Business getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Business businessId) {
        this.businessId = businessId;
    }

    public String getNameTypeMoney() {
        return nameTypeMoney;
    }

    public void setNameTypeMoney(String nameTypeMoney) {
        this.nameTypeMoney = nameTypeMoney;
    }

    public float getTypeChangeTypemoney() {
        return typeChangeTypemoney;
    }

    public void setTypeChangeTypemoney(float typeChangeTypemoney) {
        this.typeChangeTypemoney = typeChangeTypemoney;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
