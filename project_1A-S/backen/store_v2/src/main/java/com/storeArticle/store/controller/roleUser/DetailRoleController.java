package com.storeArticle.store.controller.roleUser;

import com.storeArticle.store.model.accounts.DetailRole;
import com.storeArticle.store.model.accounts.RoleUser;
import com.storeArticle.store.service.roleService.DetailRoleService;
import com.storeArticle.store.service.roleService.RoleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RestController
@RequestMapping(value="/detailRole")
@CrossOrigin(methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE  })
public class DetailRoleController {

    @Autowired
    private DetailRoleService detailRoleService;

    @PostMapping(value = "/lookForDetailRole")
    public List<DetailRole> lookForDetailRole(@RequestBody String detailProvider)throws IOException {
        return detailRoleService.getListDetailRole(detailProvider);
    }

/*    @GetMapping(value = "/listRoleUser")
    public List<RoleUser> listRoleUser()throws IOException {
        return roleUserService.getListRoleUser();
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
