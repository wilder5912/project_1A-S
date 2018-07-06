package com.storeArticle.store.controller.product;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.storeArticle.store.model.groupProductModel.SubSection;
import com.storeArticle.store.service.dto.SelectVEO;
import com.storeArticle.store.service.groupProductService.SubSectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RestController
@RequestMapping(value="/subSection")
@CrossOrigin(methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class SubSectionController {

    @Autowired
    private SubSectionService subSectionService;

    protected ObjectMapper mapper;

    public SubSectionController(){
        mapper = new ObjectMapper();
    }
    @GetMapping(value="/getSubSection")
    public List<SubSection> getSubSection() throws  IOException{
        return subSectionService.getSubSectionList();
    }

    @PostMapping(value="/addSubSection")
    public boolean addSubSection(@RequestBody String subSectionData)throws IOException {
        SubSection subSection = this.mapper.readValue(subSectionData,SubSection.class);
        return subSectionService.addSubSection(subSection);
    }

    @GetMapping(value = "/deleteSubSectionId/{idSection}")
    public boolean deleteSectionId(@PathVariable("idSection") int idSection){
        return subSectionService.deleteSubSection(idSection);
    }

    @PostMapping(value = "/updateSubSection")
    public boolean updateSubSection(@RequestBody String sectionData)throws IOException {
        this.mapper = new ObjectMapper();
        SubSection subSection = this.mapper.readValue(sectionData, SubSection.class);
        return subSectionService.updatedGroupProductName(subSection);
    }

    @GetMapping(value = "/getSectionSubSectionIdList/{idSection}")
    public List<SelectVEO> getSectionSubSectionIdList(@PathVariable("idSection") int idSection){
        return subSectionService.getListSelectDTO(idSection);
    }


}
