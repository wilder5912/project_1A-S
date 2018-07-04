package com.storeArticle.store.service.dto;

import com.storeArticle.store.model.accounts.Business;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class SelectDTOService {

    public List<SelectVEO> getBussineDTO(List<Object> bussineList){
        List<SelectVEO> bussineDTOList = new ArrayList<SelectVEO>();
        try{
                bussineList.forEach(BussineData->{
                    Business bussine = (Business)BussineData;
                    SelectVEO bussineDTOInfo = new SelectVEO();
                    bussineDTOInfo.setValue( new String(bussine.getBusinessId()+""));
                    bussineDTOInfo.setLabel((String)bussine.getNameBu());
                    bussineDTOList.add(bussineDTOInfo);
            });
        }catch(Exception e){

        }finally{
        }
        return bussineDTOList;
    }



    public List<SelectVEO> getIdNameDTO(List<Object[]> idNameList){
        List<SelectVEO> selectDTOList = new ArrayList<SelectVEO>();
        try{
            idNameList.forEach(SelectData->{
                SelectVEO selectInfo = new SelectVEO();
                selectInfo.setValue(SelectData[0].toString());
                selectInfo.setLabel(SelectData[1].toString());
                selectDTOList.add(selectInfo);
            });
        }catch(Exception e){
        }finally{
        }
        return selectDTOList;
    }

    public List<SelectVEO> getIdNameDTOAndId(List<Object[]> idNameList){
        List<SelectVEO> selectDTOList = new ArrayList<SelectVEO>();
        try{
            idNameList.forEach(SelectData->{
                SelectVEO selectInfo = new SelectVEO();
                selectInfo.setValue(SelectData[0].toString());
                selectInfo.setLabel(SelectData[0].toString()+" "+SelectData[1].toString());
                selectDTOList.add(selectInfo);
            });
        }catch(Exception e){
        }finally{
        }
        return selectDTOList;
    }

    public List<SelectVEO> getIdNameDTOAndIdCode(List<Object[]> idNameList){
        List<SelectVEO> selectDTOList = new ArrayList<SelectVEO>();
        try{
            idNameList.forEach(SelectData->{
                SelectVEO selectInfo = new SelectVEO();
                selectInfo.setValue(SelectData[0].toString());
                selectInfo.setLabel(SelectData[0].toString()+" "+SelectData[1].toString()+ " " +  SelectData[2].toString());
                selectDTOList.add(selectInfo);
            });
        }catch(Exception e){
        }finally{
        }
        return selectDTOList;
    }

}
