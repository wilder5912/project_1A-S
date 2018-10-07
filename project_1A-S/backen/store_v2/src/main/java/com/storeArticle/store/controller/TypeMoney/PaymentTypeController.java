package com.storeArticle.store.controller.TypeMoney;

import com.storeArticle.store.model.TypeMoneyModel.TypeMoney;
import com.storeArticle.store.service.TypeMoneyStoreService.PaymentTypeService;
import com.storeArticle.store.service.dto.SelectVEO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RestController
@RequestMapping(value="/paymentType")
@CrossOrigin(methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE  })
public class PaymentTypeController {

    @Autowired
    private PaymentTypeService paymentTypeService;

    @GetMapping(value = "/listPaimentType")
    public List<SelectVEO> listPaimentType()throws IOException {
        return this.paymentTypeService.getListSelectDTO();
    }
}
