package com.storeArticle.store.controller.warehouse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.storeArticle.store.model.warehouse.Warehouse;
import com.storeArticle.store.service.warehouseProductService.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RestController
@RequestMapping(value="/warehouse")
@CrossOrigin(methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class warehouseController {

    @Autowired
    private WarehouseService warehouseService;

    protected ObjectMapper mapper;
    public warehouseController(){
        mapper = new ObjectMapper();
    }

    @PostMapping(value = "/addWarehouse")
    public boolean addProvider(@RequestBody Warehouse warehouse)throws IOException {
        return warehouseService.addWarehouse(warehouse);
    }

    @GetMapping(value = "/listWarehouse")
    public List<Warehouse> listProvider()throws IOException{
        return warehouseService.getWarehouseListAll();
    }
    @GetMapping(value = "/listWarehouseCode")
    public List<String> listWarehouseCode()throws IOException{
        return warehouseService.getWarehouseCodeListAll();
    }
    @PostMapping(value = "/deleteWarehouse")
    public boolean deleteWarehouse(@RequestBody Warehouse warehouse)throws IOException {
        return warehouseService.deleteWarehouseList(warehouse.getWarehouseId());
    }

    @PostMapping(value = "/editWarehouser")
    public boolean editWarehouse(@RequestBody Warehouse warehouse)throws IOException {
        return warehouseService.updatedWarehouse(warehouse);
    }

    @GetMapping(value = "/getWarehouserNumArticle/{codeArticle}/{businessId}")
    public int getWarehouserNumArticle(@PathVariable("codeArticle") String codeArticle,@PathVariable("businessId") int businessId )throws IOException {
        return warehouseService.getWarehouseNumArticle(codeArticle,businessId );
    }



}
