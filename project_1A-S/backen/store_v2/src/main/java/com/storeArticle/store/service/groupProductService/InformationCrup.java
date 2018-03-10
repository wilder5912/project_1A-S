package com.storeArticle.store.service.groupProductService;

import com.storeArticle.store.model.accounts.Information;

public interface InformationCrup {

    boolean addInformation(Information information);

    boolean deleteInformation(int informationId);

    boolean updatedInformation(Information information);

    Information getInformation(int InformationId);

    Boolean getIsInformation();
}
