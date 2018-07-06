package com.storeArticle.store.service.boxArticle;

import com.storeArticle.store.model.groupProductModel.ListProduct;

public interface ListProductCrup {

    boolean addListProduct(ListProduct listProduct);

    boolean deleteListProduct(int listProductId);

    boolean updatedListProduct(ListProduct listProduct);

    ListProduct getListProduct(int listProductId);

    Boolean getIsListProduct();
}
