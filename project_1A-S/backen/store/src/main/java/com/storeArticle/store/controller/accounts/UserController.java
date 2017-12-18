package com.storeArticle.store.controller.accounts;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.storeArticle.store.model.accounts.User;
import com.storeArticle.store.service.accounts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RestController
@RequestMapping(value="/user")
@CrossOrigin(methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class UserController {

    @Autowired
    private UserService userService;
    protected ObjectMapper mapper;
    private User user;

    @PostMapping(value = "/getUser")
    public boolean getUSer(@RequestBody String user)throws JsonParseException, JsonMappingException, IOException {
        this.mapper = new ObjectMapper();
        User user2 = this.mapper.readValue(user, User.class);
        String s =user;
        return true;
    }
    @PostMapping(value = "/addUser")
        public boolean addUser(@RequestBody String userData)throws JsonParseException, JsonMappingException, IOException {
            this.mapper = new ObjectMapper();
            User user = this.mapper.readValue(userData, User.class);
            user.setTypeUser("User");
            if(userService.isCreateUser(user.getEmailUser())) {
                userService.addUser(user);
                return true;
            }
            return false;
    }

    @PostMapping(value = "/loginUser")
    public User loginUser(@RequestBody String userData)throws JsonParseException, JsonMappingException, IOException {
        this.mapper = new ObjectMapper();
        user = this.mapper.readValue(userData, User.class);
        user = userService.getUserData(user);
        return user;
    }

    @PostMapping(value = "/isLoginUser")
    public User isLoginUser(@RequestBody String userData)throws JsonParseException, JsonMappingException, IOException {
        this.mapper = new ObjectMapper();
        User userActuali = this.mapper.readValue(userData, User.class);
        return userService.getUserActual(user,userActuali);
    }

    @GetMapping(value = "/logoutUser")
    public Boolean logoutUser()throws JsonParseException, JsonMappingException, IOException {
        user = null;
        return false;
    }

}



