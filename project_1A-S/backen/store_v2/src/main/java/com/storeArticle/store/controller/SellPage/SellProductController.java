package com.storeArticle.store.controller.SellPage;

import com.storeArticle.store.model.SellModel.SellProduct;
import com.storeArticle.store.service.sellService.SellProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RestController
@RequestMapping(value="/sellProduct")
@CrossOrigin(methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE  })
public class SellProductController {
    @Autowired
    private SellProductService sellProductService;
    @PostMapping(value = "/addSellProduct")
    public List<SellProduct>  addSellProduct(@RequestBody List<SellProduct> listSellProduct)throws IOException {
        return sellProductService.addSellProductLisy(listSellProduct);
    }

    @PostMapping(value = "/addSellProductS")
    public boolean addSellProductS(@RequestBody SellProduct listSellProduct)throws IOException {
        return sellProductService.addSellProductLisyD(listSellProduct);
    }



}
