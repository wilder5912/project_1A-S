package com.storeArticle.store.service.dto;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Repository
public class GroupProductDTOService {

    public List<GroupProductDTO> getProductoIdNameDTO(List<Object[]> groupProductList){
        List<GroupProductDTO> groupProductDTOList = new ArrayList<GroupProductDTO>();
        try{
            groupProductList.forEach(groupProductData->{
                GroupProductDTO groupProduct1Info = new GroupProductDTO();
                groupProduct1Info.setGroupId((Integer)groupProductData[0]);
                groupProduct1Info.setNameGroup((String)groupProductData[1]);
                groupProductDTOList.add(groupProduct1Info);
            });
        }catch(Exception e){
        }finally{
        }
        return groupProductDTOList;
    }
}
