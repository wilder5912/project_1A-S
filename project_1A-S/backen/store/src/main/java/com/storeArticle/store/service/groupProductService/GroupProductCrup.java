package com.storeArticle.store.service.groupProductService;

import com.storeArticle.store.model.accounts.GroupProduct;

public interface GroupProductCrup {

    boolean addGroupProductName(GroupProduct groupProduct);

    void deleteGroupProductName(int userId);

    void updatedGroupProductName(int userId, GroupProduct groupProduct);

    GroupProduct getGroupProductName(int userId);

    Boolean getIsGroupProductName();
}
