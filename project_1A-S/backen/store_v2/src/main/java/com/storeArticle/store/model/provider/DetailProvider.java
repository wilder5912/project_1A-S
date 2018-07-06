package com.storeArticle.store.model.provider;


import com.storeArticle.store.model.groupProductModel.Business;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="detailprovider")
public class DetailProvider implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "detailprovider_id")
    private int detailProviderId;

    @ManyToOne
    @JoinColumn(name = "provider_id")
    private Provider providerId;

    @ManyToOne
    @JoinColumn(name = "business_id")
    private Business businessId;

    @Column(name = "is_delete_detailprovider")
    private boolean isDelete;

    public int getDetailProviderId() {
        return detailProviderId;
    }

    public void setDetailProviderId(int detailProviderId) {
        this.detailProviderId = detailProviderId;
    }

    public Provider getProviderId() {
        return providerId;
    }

    public void setProviderId(Provider providerId) {
        this.providerId = providerId;
    }

    public Business getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Business businessId) {
        this.businessId = businessId;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
