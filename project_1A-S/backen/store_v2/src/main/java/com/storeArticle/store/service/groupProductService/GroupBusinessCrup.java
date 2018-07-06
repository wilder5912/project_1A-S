package com.storeArticle.store.service.groupProductService;

import com.storeArticle.store.model.groupProductModel.Business;
import com.storeArticle.store.model.groupProductModel.GroupProduct;

public interface GroupBusinessCrup {

    boolean addBusiness(Business business);

    boolean deleteBusiness(int businessId);

    boolean updatedBusiness(Business business);

    Business getBusiness(int businessId);

    Boolean getIsBusiness();
}
