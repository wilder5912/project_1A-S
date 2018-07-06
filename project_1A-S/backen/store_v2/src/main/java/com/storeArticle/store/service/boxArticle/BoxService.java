package com.storeArticle.store.service.boxArticle;


import com.storeArticle.store.model.boxModel.Box;
import com.storeArticle.store.model.groupProductModel.Business;
import com.storeArticle.store.model.groupProductModel.ListProduct;
import com.storeArticle.store.model.accounts.User;
import com.storeArticle.store.service.accounts.UserService;
import com.storeArticle.store.service.dto.BoxDTOService;
import com.storeArticle.store.service.dto.BoxVEO;
import com.storeArticle.store.service.enumPage.BoxEnum;
import com.storeArticle.store.service.groupProductService.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Transactional
@Service
public class BoxService implements BoxCrup {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private BoxDTOService boxDTOService;

    @Autowired
    private ListProductService listProductService;

    @Autowired
    private UserService userService;

    @Autowired
    private BusinessService bussineService;

    @Override
    public boolean addBox(Box box) {
        boolean isBox=false;
        //Box aa = getBox(box.getBoxId());
        if(null == getBox(box.getBoxId())) {
            isBox = true;
            box.setNameBox("Lista Articulos");
            box.setDelete(false);
            box.setSelectBox(true);
            entityManager.persist(box);
        }
        return isBox;
    }

    @Override
    public boolean deleteBox(int boxId) {
        return false;
    }

    @Override
    public boolean updatedBox(Box box) {
        return false;
    }

    @Override
    public Box getBox(int boxId) {
        return entityManager.find(Box.class, boxId);
    }

    @Override
    public Boolean getIsBox() {
        return null;
    }


    public BoxVEO getBoxArticle(Box box) {
        Box boxData = getBoxUserSelect(box);
        return boxDTOService.getBoxArticleDTO(boxData, listProductService.getListArticle(boxData.getBoxId()));

    }

    public boolean addArticleBoxOrCreateBox(ListProduct listProduct){
        ListProduct listProduct1Data = new ListProduct();
        ListProduct listProduct1DataNew;
        Box boxData =listProduct.getBoxId();
        boxData.setCodeBox(userService.randomString());
        //boolean isCreate = addBox(boxData);

       // if(!isCreate){
            listProduct1Data = listProductService.getListArticleData(listProduct);
            listProduct1DataNew = listProductService.getListProduct(listProduct1Data.getListProductId());

            if(null != listProduct1DataNew) {
                listProduct1DataNew.setNumProduct(listProduct1DataNew.getNumProduct() + listProduct.getNumProduct());
                entityManager.flush();
            }else{
                listProduct.setNumProduct(listProduct.getNumProduct());
                listProductService.addListProduct(listProduct);
            }
        //}
        /*else{
            boxData.setBoxId(getListArticleData(boxData));
            User user = userService.getUser(boxData.getUserId().getUserID());
            user.setIdBoxUser(boxData.getBoxId());
            entityManager.flush();
            listProduct.setNumProduct(1);

            listProductService.addListProduct(listProduct);
        }*/
        return true;
    }

    public int getListArticleData(Box box ){
        int boxData;
        try{
            boxData = (Integer)entityManager.createQuery(BoxEnum.getBox.getHql())
                    .setParameter(1, box.getUserId().getUserID())
                    .setParameter(2, box.getCodeBox())
                    .setParameter(3, false)
                    .getSingleResult();
        }catch (RuntimeException e){
            boxData = 0;
        }
        return boxData;
    }

    public void addBoxUser(User user){
        Box box = new Box();
        box.setCodeBox(user.getCodeUser());
        box.setUserID(user);
        Business businne = (Business)bussineService.getBusiness().get(0);
        box.setBusinessId(businne);
        addBox(box);

    }
    public Box getBoxUserSelect(Box box){
        Box boxData;
        try{
            boxData = (Box)entityManager.createQuery(BoxEnum.getBoxUser.getHql())
                    .setParameter(1, box.getUserId().getUserID())
                    .setParameter(2, box.getBusinessId().getBusinessId())
                    .setParameter(3, true)
                    .setParameter(4, false)
                    .getSingleResult();
        }catch (RuntimeException e){
            boxData = null;
        }
        return boxData;
    }
}
