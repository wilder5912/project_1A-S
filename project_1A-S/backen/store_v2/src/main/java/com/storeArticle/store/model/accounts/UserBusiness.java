package com.storeArticle.store.model.accounts;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "userbusiness")
public class UserBusiness implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "businesscurouser_id")
    private int businessCurouserId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userID;

    @ManyToOne
    @JoinColumn(name = "business_id")
    private User businessId;

    public int getBusinessCurouserId() {
        return businessCurouserId;
    }

    public void setBusinessCurouserId(int businessCurouserId) {
        this.businessCurouserId = businessCurouserId;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    public User getBusinessId() {
        return businessId;
    }

    public void setBusinessId(User businessId) {
        this.businessId = businessId;
    }
}
