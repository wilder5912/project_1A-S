package com.storeArticle.store.controller.provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.storeArticle.store.model.provider.Provider;
import com.storeArticle.store.service.ProviderProductService.ProviderService;
import com.storeArticle.store.service.dto.SelectVEO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
@RestController
@RequestMapping(value="/provider")
@CrossOrigin(methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    protected ObjectMapper mapper;
    public ProviderController(){
        mapper = new ObjectMapper();
    }

    @PostMapping(value = "/addProvider")
    public boolean addProvider(@RequestBody Provider provider, ServletRequest servletRequest)throws IOException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        String userPrincipal = request.getHeader("access-token");

        return providerService.addprovider(provider);
    }

    @GetMapping(value = "/listProvider")
    public List<Provider>  listProvider()throws IOException{
        return providerService.getProviderListAll();
    }

    @GetMapping(value = "/listProviderDTO")
    public List<SelectVEO> listProviderDTO()throws IOException{
        return providerService.getProviderIdCodeDTO();
    }

    @PostMapping(value = "/deleteProvider")
    public boolean deleteProvider(@RequestBody Provider provider)throws IOException {
        return providerService.deleteProvider(provider.getProviderId());
    }

    @PostMapping(value = "/editProvider")
    public boolean editProvider(@RequestBody Provider provider)throws IOException {
        return providerService.updatedProviderForId(provider);
    }
}
