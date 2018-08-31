package com.storeArticle.store.controller.provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.storeArticle.store.model.accounts.DetailRole;
import com.storeArticle.store.model.provider.DetailProvider;
import com.storeArticle.store.model.provider.Provider;
import com.storeArticle.store.service.ProviderProductService.DetailProviderService;
import com.storeArticle.store.service.ProviderProductService.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RestController
@RequestMapping(value="/detailProvider")
@CrossOrigin(methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class DetailProviderController {

    @Autowired
    private DetailProviderService detailProviderService;

    protected ObjectMapper mapper;
    public DetailProviderController(){
        mapper = new ObjectMapper();
    }

    @PostMapping(value = "/addDetailProvider")
    public boolean addDetailProvider(@RequestBody DetailProvider detailProvider)throws IOException {
        return detailProviderService.addDetailProvider(detailProvider);
    }

    @GetMapping(value = "/listDetailProvider")
    public List<DetailProvider>  listDetailProvider()throws IOException{
        return detailProviderService.getDetailProviderListAll();
    }

    @PostMapping(value = "/deleteDetailProvider")
    public boolean deleteDetailProvider(@RequestBody DetailProvider detailProvider)throws IOException {
        return detailProviderService.deleteDetailProvider(detailProvider.getDetailProviderId());
    }

    @PostMapping(value = "/editDetailProvider")
    public boolean editDetailProvider(@RequestBody DetailProvider detailProvider)throws IOException {
        return detailProviderService.updatedDetailProviderForId(detailProvider);
    }
}
