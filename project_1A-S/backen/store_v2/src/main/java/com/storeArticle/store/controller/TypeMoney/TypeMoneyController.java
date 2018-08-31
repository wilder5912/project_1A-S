package com.storeArticle.store.controller.TypeMoney;

import com.storeArticle.store.model.TypeMoneyModel.TypeMoney;
import com.storeArticle.store.model.provider.Provider;
import com.storeArticle.store.service.TypeMoneyStoreService.TypeMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RestController
@RequestMapping(value="/typeMoney")
@CrossOrigin(methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE  })
public class TypeMoneyController {

    @Autowired
    private TypeMoneyService typeMoneyService;

    @GetMapping(value = "/listTypeMoneyBusiness/{idBusiness}")
    public List<TypeMoney> listProvider(@PathVariable("idBusiness") int idBusiness)throws IOException {
        return typeMoneyService.getNameTypeMoneybusinessId(idBusiness);
    }
    @PostMapping(value = "/addTypeMoney")
    public boolean addTypeMoney(@RequestBody TypeMoney typeMoney)throws IOException {
        return typeMoneyService.addTypeMoney(typeMoney);
    }
    @PostMapping(value = "/editTypeMoney")
    public boolean editTypeMoney(@RequestBody TypeMoney typeMoney)throws IOException {
        return typeMoneyService.updatedTypeMoney(typeMoney);
    }
    @PostMapping(value = "/deleteTypeMoney")
    public boolean deleteTypeMoney(@RequestBody TypeMoney typeMoney)throws IOException {
        return typeMoneyService.deleteTypeMoney(typeMoney.getTypeMoneyId());
    }
}
