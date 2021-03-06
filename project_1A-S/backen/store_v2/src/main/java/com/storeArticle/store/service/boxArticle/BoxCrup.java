package com.storeArticle.store.service.boxArticle;

import com.storeArticle.store.model.boxModel.Box;

public interface BoxCrup {

    boolean addBox(Box box);

    boolean deleteBox(int boxId);

    boolean updatedBox(Box box);

    Box getBox(int boxId);

    Boolean getIsBox();
}
