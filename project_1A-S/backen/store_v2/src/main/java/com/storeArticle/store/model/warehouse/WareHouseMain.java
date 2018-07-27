package com.storeArticle.store.model.warehouse;

import com.storeArticle.store.model.groupProductModel.ArticleDetail;
import com.storeArticle.store.model.groupProductModel.Business;
import com.storeArticle.store.model.provider.ArticleProvider;
import com.storeArticle.store.model.provider.Provider;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="warehousemain")
public class WareHouseMain implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "wname_id")
    private int wnameId;

    @Column(name = "code_wname")
    private String codeWarehouse;

    @Column(name = "address_wname")
    private String addressWName;

    @Column(name = "is_delete_wname")
    private boolean isDelete;

    public int getWnameId() {
        return wnameId;
    }

    public void setWnameId(int wnameId) {
        this.wnameId = wnameId;
    }

    public String getCodeWarehouse() {
        return codeWarehouse;
    }

    public void setCodeWarehouse(String codeWarehouse) {
        this.codeWarehouse = codeWarehouse;
    }

    public String getAddressWName() {
        return addressWName;
    }

    public void setAddressWName(String addressWName) {
        this.addressWName = addressWName;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}