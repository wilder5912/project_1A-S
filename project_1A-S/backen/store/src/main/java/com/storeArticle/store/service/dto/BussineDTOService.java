package com.storeArticle.store.service.dto;

import com.storeArticle.store.model.accounts.Bussine;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Repository
public class BussineDTOService {

    public List<BussineDTO> getBussineDTO(List<Object> bussineList){
        List<BussineDTO> bussineDTOList = new ArrayList<BussineDTO>();
        try{
                bussineList.forEach(BussineData->{
                Bussine bussine = (Bussine)BussineData;
                BussineDTO bussineDTOInfo = new BussineDTO();
                bussineDTOInfo.setValue( new String(bussine.getBussineId()+""));
                bussineDTOInfo.setLabel((String)bussine.getNombreBu());
                bussineDTOList.add(bussineDTOInfo);
            });
        }catch(Exception e){
        }finally{
        }
        return bussineDTOList;
    }
}
