package com.storeArticle.store.controller.accounts;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.storeArticle.store.model.accounts.User;
import com.storeArticle.store.service.accounts.UserService;
import com.storeArticle.store.service.boxArticle.BoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RestController
@RequestMapping(value="/user")
@CrossOrigin(methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class UserController  {

    @Autowired
    private UserService userService;
    @Autowired
    private BoxService boxService;

    protected ObjectMapper mapper;
    private User user;

    @PostMapping(value = "/getUser")
    public boolean getUSer(@RequestBody String user)throws IOException {
        this.mapper = new ObjectMapper();
        User user2 = this.mapper.readValue(user, User.class);
        String s =user;
        return true;
    }
    @PostMapping(value = "/getUserId")
    public User getUserId(@RequestBody int userId){
        return userService.getUser(userId);
    }

    @PostMapping(value = "/addUser")
        public User addUser(@RequestBody String userData)throws IOException {
            this.mapper = new ObjectMapper();
            User userJson = this.mapper.readValue(userData, User.class);
            userJson.setTypeUser("User");
            if(userService.isCreateUser(userJson.getEmailUser())) {
                userService.addUser(userJson);
                User  userInfo = userService.getAutentification(userJson.getEmailUser(),userJson.getPassword());
                boxService.addBoxUser(userInfo);
                return userInfo;
            }
            return null;
    }

    @PostMapping(value = "/loginUser")
    public User loginUser(@RequestBody String userData)throws IOException {
        this.mapper = new ObjectMapper();
        User userJson = this.mapper.readValue(userData, User.class);
        return (User)userService.getUserData(userJson);//1
    }

    @PostMapping(value = "/isLoginUser")
    public User isLoginUser(@RequestBody String userData)throws  IOException {

        this.mapper = new ObjectMapper();
        User userActuali = this.mapper.readValue(userData, User.class);
        String token = userActuali.getTokenUser();

        return userService.getUserActual(user,userActuali,token);
    }

    @GetMapping(value = "/logoutUser")
    public Boolean logoutUser()throws IOException {
       // user = null;
        return false;
    }

    @PostMapping(value ="/editImageUserOne")
    public ResponseEntity<String> editImageUserOne(@RequestParam("file") MultipartFile file, @RequestParam("userData") String userData) {
        String message = "";

        try {
            this.mapper = new ObjectMapper();
            User userActuali = this.mapper.readValue(userData, User.class);

            user = userService.editImageUserOne(file,userActuali);
            message = "You successfully uploaded " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            message = "FAIL to upload " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile2(@PathVariable String filename) {
        Resource file = userService.loadFile(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "-\"")
                .body(file);
    }

    @PostMapping(value = "/editUserRol")
    public boolean editUserRol(@RequestBody User user)throws IOException {
        return userService.updatedUserRole(user);
    }

}


