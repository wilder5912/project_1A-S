package com.storeArticle.store.controller.ClientPage;

import com.storeArticle.store.model.clientModel.Client;
import com.storeArticle.store.service.clientProductService.ClientService;
import com.storeArticle.store.service.dto.SelectVEO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RestController
@RequestMapping(value="/client")
@CrossOrigin(methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE  })
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping(value = "/addClient")
    public boolean addCleint(@RequestBody Client client)throws IOException {
        return clientService.addClient(client);
    }

    @PostMapping(value = "/getListClient")
    public List<SelectVEO> getListClient(@RequestBody String infoClient ){
        return clientService.getListSelectDTO(infoClient);
    }
    @PostMapping(value = "/geClientId")
    public Client geClientId(@RequestBody int clientId ){
        return clientService.getClient(clientId);
    }





/*    @GetMapping(value = "/listRoleUser")
    public List<RoleUser> listRoleUser()throws IOException {
        return roleUserService.getListRoleUser();
    }
    @GetMapping(value = "/listAllRole")
    public List<SelectVEO> listAllRole()throws IOException {
        return roleUserService.getListSelectDTO();
    }

    @PostMapping(value = "/addRoleUser")
    public boolean addRoleUser(@RequestBody RoleUser roleUser)throws IOException {
        return roleUserService.addTypeMoney(roleUser);
    }
    @PostMapping(value = "/editRoleUser")
    public boolean editRoleUser(@RequestBody RoleUser roleUser)throws IOException {
        return roleUserService.updatedRoleUser(roleUser);
    }
    @PostMapping(value = "/deleteRoleUser")
    public boolean deleteRoleUser(@RequestBody RoleUser roleUser)throws IOException {
        return roleUserService.deleteRoleUser(roleUser.getRoleUserId());
    }*/

}
