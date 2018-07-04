package com.storeArticle.store.service.groupProductService;

import com.storeArticle.store.model.accounts.Business;
import com.storeArticle.store.model.accounts.GroupProduct;

public interface GroupBussineCrup {

    boolean addBussine(GroupProduct groupProduct);

    void deleteBussine(int userId);

    void updatedBussine(int userId, GroupProduct groupProduct);

    Business getBussine(int bussineId);

    Boolean getIsBussine();
}
