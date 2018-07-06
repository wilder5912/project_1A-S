package com.storeArticle.store.controller.product;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.storeArticle.store.model.groupProductModel.Section;
import com.storeArticle.store.service.dto.SelectVEO;
import com.storeArticle.store.service.groupProductService.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RestController
@RequestMapping(value="/section")
@CrossOrigin(methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class SectionController {

    @Autowired
    private SectionService sectionService;

    protected ObjectMapper mapper;

    public SectionController(){
        mapper = new ObjectMapper();
    }
    @PostMapping(value="/addSection")
    public boolean addSection(@RequestBody String sectionData)throws  IOException {
        Section section = this.mapper.readValue(sectionData,Section.class);
        return sectionService.addSection(section);
    }

    @GetMapping(value="/getSection")
    public List<Section> getSection() throws  IOException{
        return sectionService.getSubSectionList();
    }

    @GetMapping(value = "/getSectionIdList/{idGroup}")
    public List<SelectVEO> getSectionId(@PathVariable("idGroup") int idGroup){
        return sectionService.getListSelectDTO(idGroup);
    }



    @GetMapping(value = "/deleteSectionId/{idSection}")
    public boolean deleteSectionId(@PathVariable("idSection") int idSection){
        return sectionService.deleteSection(idSection);
    }


    @PostMapping(value = "/updateSection")
    public boolean updateSection(@RequestBody String sectionData)throws  IOException {
        this.mapper = new ObjectMapper();
        Section section = this.mapper.readValue(sectionData, Section.class);
        return sectionService.updatedGroupProductName(section);
    }

    @GetMapping(value = "/getSectionList/{idGroup}")
    public List<SelectVEO> getBussineGroupList(@PathVariable("idGroup") String idGroup){
        return sectionService.getListSelectDTO(Integer.parseInt(idGroup));
    }

}
