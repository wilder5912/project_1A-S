package com.storeArticle.store.model.warehouse;

import com.storeArticle.store.model.groupProductModel.ArticleDetail;
import com.storeArticle.store.model.groupProductModel.Business;
import com.storeArticle.store.model.provider.ArticleProvider;
import com.storeArticle.store.model.provider.Provider;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="warehouse")
public class Warehouse implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "warehouse_id")
    private int warehouseId;

    @ManyToOne
    @JoinColumn(name = "articledetail_id")
    private ArticleDetail articleDetailId;

    @Column(name = "quantyti_provider_warehouse")
    private int quantytiProviderWarehouse;

    @ManyToOne
    @JoinColumn(name = "articleprovider_id")
    private ArticleProvider articleProviderId;

    @ManyToOne
    @JoinColumn(name = "wname_id")
    private WareHouseMain wnameId;

    @ManyToOne
    @JoinColumn(name = "provider_id")
    private Provider providerId;

    @ManyToOne
    @JoinColumn(name = "business_id")
    private Business businessId;

    @Column(name = "fature_warehouse")
    private String fatureWarehouse;

    @Column(name = "date_start_warehouse")
    private String dateStartWarehouse;

    @Column(name = "date_end_warehouse")
    private String dateEndWarehouse;

    @Column(name = "code_warehouse")
    private String codeWarehouse;

    @Column(name = "quantyti_currect_warehouse")
    private int quantytiCurrectWarehouse;

    @Column(name = "is_delete_warehouse")
    private boolean isDelete;

    public Business getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Business businessId) {
        this.businessId = businessId;
    }

    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    public ArticleDetail getArticleDetailId() {
        return articleDetailId;
    }

    public void setArticleDetailId(ArticleDetail articleDetailId) {
        this.articleDetailId = articleDetailId;
    }

    public int getQuantytiProviderWarehouse() {
        return quantytiProviderWarehouse;
    }

    public void setQuantytiProviderWarehouse(int quantytiProviderWarehouse) {
        this.quantytiProviderWarehouse = quantytiProviderWarehouse;
    }

    public ArticleProvider getArticleProviderId() {
        return articleProviderId;
    }

    public void setArticleProviderId(ArticleProvider articleProviderId) {
        this.articleProviderId = articleProviderId;
    }

    public Provider getProviderId() {
        return providerId;
    }

    public void setProviderId(Provider providerId) {
        this.providerId = providerId;
    }

    public String getFatureWarehouse() {
        return fatureWarehouse;
    }

    public void setFatureWarehouse(String fatureWarehouse) {
        this.fatureWarehouse = fatureWarehouse;
    }

    public String getDateStartWarehouse() {
        return dateStartWarehouse;
    }

    public void setDateStartWarehouse(String dateStartWarehouse) {
        this.dateStartWarehouse = dateStartWarehouse;
    }

    public String getDateEndWarehouse() {
        return dateEndWarehouse;
    }

    public void setDateEndWarehouse(String dateEndWarehouse) {
        this.dateEndWarehouse = dateEndWarehouse;
    }

    public String getCodeWarehouse() {
        return codeWarehouse;
    }

    public void setCodeWarehouse(String codeWarehouse) {
        this.codeWarehouse = codeWarehouse;
    }

    public int getQuantytiCurrectWarehouse() {
        return quantytiCurrectWarehouse;
    }

    public void setQuantytiCurrectWarehouse(int quantytiCurrectWarehouse) {
        this.quantytiCurrectWarehouse = quantytiCurrectWarehouse;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}

