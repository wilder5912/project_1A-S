package com.storeArticle.store.model.accounts;

import com.storeArticle.store.model.groupProductModel.Business;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "businesscurrentuser")
public class BusinessCurrentUser implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="businesscurouser_id")
    private int businesscurouserId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userID;

    @ManyToOne
    @JoinColumn(name = "business_id")
    private Business businessId;

    @Column(name = "is_delete_businesscurouser")
    private boolean isDelete;

    public int getBusinesscurouserId() {
        return businesscurouserId;
    }

    public void setBusinesscurouserId(int businesscurouserId) {
        this.businesscurouserId = businesscurouserId;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
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
