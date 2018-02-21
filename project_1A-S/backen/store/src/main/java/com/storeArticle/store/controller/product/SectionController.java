package com.storeArticle.store.controller.product;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.storeArticle.store.model.accounts.Section;
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
    public boolean addSection(@RequestBody String sectionData)throws JsonParseException, JsonMappingException, IOException {
        Section section = this.mapper.readValue(sectionData,Section.class);
        return sectionService.addSection(section);
    }

    @GetMapping(value="/getSection")
    public List<Section> getSection() throws JsonParseException, JsonMappingException, IOException{
        return sectionService.getSetionList();
    }

    @GetMapping(value = "/deleteSectionId/{idSection}")
    public boolean deleteSectionId(@PathVariable("idSection") int idSection){
        return sectionService.deleteSection(idSection);
    }

    @PostMapping(value = "/updateSection")
    public boolean updateSection(@RequestBody String sectionData)throws JsonParseException, JsonMappingException, IOException {
        this.mapper = new ObjectMapper();
        Section section = this.mapper.readValue(sectionData, Section.class);
        return sectionService.updatedGroupProductName(section);
    }

}
