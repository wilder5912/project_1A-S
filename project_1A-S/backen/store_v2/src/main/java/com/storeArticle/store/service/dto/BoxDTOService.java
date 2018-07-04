package com.storeArticle.store.service.dto;

import com.storeArticle.store.model.accounts.Box;
import com.storeArticle.store.model.accounts.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoxDTOService{
    @Autowired
    private ListProductDTOService ListProductDTOService;

    public BoxVEO getBoxArticleDTO(Box box , List<Object[]> listArticle){
        BoxVEO boxVEO = new BoxVEO();
        User user = new User();
        user.setUserID(box.getUserId().getUserID());
        boxVEO.setBoxId(box.getBoxId());
        boxVEO.setBusinessId(box.getBusinessId());
        boxVEO.setNameBox(box.getNameBox());
        boxVEO.setCodeBox(box.getCodeBox());
        boxVEO.setSelectBox(box.isSelectBox());
        boxVEO.setDelete(box.isDelete());
        boxVEO.setListProductVEO(ListProductDTOService.getListProductVEO(listArticle));

        boxVEO.setUserId(user);
        return boxVEO;
    }



}

