package com.dev.java.learnspringjpa.controller;

import com.dev.java.learnspringjpa.entity.UserEntity;
import com.dev.java.learnspringjpa.model.request.UserSaveRequest;
import com.dev.java.learnspringjpa.model.response.GeneralResponse;
import com.dev.java.learnspringjpa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/get-all")
    public GeneralResponse getAll(){
        List<UserEntity> datas = userService.getAll();
        return new GeneralResponse(200, "Success", "Success get data user", datas);
    }

    @PostMapping("/save")
    public GeneralResponse save(@RequestBody UserSaveRequest request){
        GeneralResponse response = userService.save(request);
        return response;
    }
}
