package com.storeArticle.store.model.TypeMoneyModel;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "paymenttype")
public class PaymentType implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "paymenttype_id")
    private int paymentTypeId;

    @Column(name = "name_paymenttype")
    private String namePaymentType;

    @Column(name = "is_delete_paymenttype")
    private boolean isDelete;

    public int getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(int paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public String getNamePaymentType() {
        return namePaymentType;
    }

    public void setNamePaymentType(String namePaymentType) {
        this.namePaymentType = namePaymentType;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}


