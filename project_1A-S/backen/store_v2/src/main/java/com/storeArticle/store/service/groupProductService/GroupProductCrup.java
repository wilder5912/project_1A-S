package com.storeArticle.store.service.groupProductService;

import com.storeArticle.store.model.groupProductModel.GroupProduct;

public interface GroupProductCrup {

    boolean addGroupProductName(GroupProduct groupProduct);

    boolean deleteGroupProductName(int groupId);

    boolean updatedGroupProductName(GroupProduct groupProduct);

    GroupProduct getGroupProductName(int groupId);

    Boolean getIsGroupProductName();
}
