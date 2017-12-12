package com.storeArticle.store.controller;


import com.storeArticle.store.entity.TypeUser;
import com.storeArticle.store.service.UserServiveI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RestController
@RequestMapping(value="/userInf")
@CrossOrigin(methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class UserController {

    @Autowired
    private UserServiveI userService;

    @GetMapping("/userData/{name}/{password}")
    public ResponseEntity<List<TypeUser>> getAllArticles(@PathVariable String name) {
        String name1= name;
        List<TypeUser> list = userService.getUser(name,"123");
        ResponseEntity<List<TypeUser>> s=new ResponseEntity<List<TypeUser>>(list, HttpStatus.OK);
        return null;

    }



}



