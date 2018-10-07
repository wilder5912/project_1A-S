package com.storeArticle.store.controller.roleUser;
import com.storeArticle.store.model.accounts.RoleUser;
import com.storeArticle.store.service.dto.SelectVEO;
import com.storeArticle.store.service.roleService.RoleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;

@Controller
@RestController
@RequestMapping(value="/roleUser")
@CrossOrigin(methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE  })
public class RoleUserController {

    @Autowired
    private RoleUserService roleUserService;

    @GetMapping(value = "/listRoleUser")
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
    }

}
