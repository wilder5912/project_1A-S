package com.storeArticle.store.service.dto;

import com.storeArticle.store.model.accounts.Bussine;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Repository
public class SelectDTOService {

    public List<SelectVEO> getBussineDTO(List<Object> bussineList){
        List<SelectVEO> bussineDTOList = new ArrayList<SelectVEO>();
        try{
                bussineList.forEach(BussineData->{
                    Bussine bussine = (Bussine)BussineData;
                    SelectVEO bussineDTOInfo = new SelectVEO();
                    bussineDTOInfo.setValue( new String(bussine.getBussineId()+""));
                    bussineDTOInfo.setLabel((String)bussine.getNombreBu());
                    bussineDTOList.add(bussineDTOInfo);
            });
        }catch(Exception e){

        }finally{
        }
        return bussineDTOList;
    }

    public List<SelectVEO> getProductoIdNameDTO(List<Object[]> groupProductList){
        List<SelectVEO> groupProductDTOList = new ArrayList<SelectVEO>();
        try{
            groupProductList.forEach(groupProductData->{
                SelectVEO groupProduct1Info = new SelectVEO();
                groupProduct1Info.setValue(groupProductData[0].toString());
                groupProduct1Info.setLabel(groupProductData[1].toString());
                groupProductDTOList.add(groupProduct1Info);
            });
        }catch(Exception e){
        }finally{
        }
        return groupProductDTOList;
    }


}
