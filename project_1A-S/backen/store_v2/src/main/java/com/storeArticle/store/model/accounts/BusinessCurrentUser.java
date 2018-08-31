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

    @Column(name = "user_id")
    private User userId;

    @ManyToOne
    @JoinColumn(name = "business_id")
    private Business businessId;

    @Column(name = "businesscurouser_select")
    private boolean buCurUserSelect;

    public int getBusinesscurouserId() {
        return businesscurouserId;
    }

    public void setBusinesscurouserId(int businesscurouserId) {
        this.businesscurouserId = businesscurouserId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Business getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Business businessId) {
        this.businessId = businessId;
    }

    public boolean isBuCurUserSelect() {
        return buCurUserSelect;
    }

    public void setBuCurUserSelect(boolean buCurUserSelect) {
        this.buCurUserSelect = buCurUserSelect;
    }
}
