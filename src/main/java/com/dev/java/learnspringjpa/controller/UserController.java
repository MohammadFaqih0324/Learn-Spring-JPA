package com.dev.java.learnspringjpa.controller;

import com.dev.java.learnspringjpa.entity.StudentEntity;
import com.dev.java.learnspringjpa.entity.UserEntity;
import com.dev.java.learnspringjpa.model.request.save.UserSaveRequest;
import com.dev.java.learnspringjpa.model.request.update.RoleUpdateRequest;
import com.dev.java.learnspringjpa.model.request.update.StudentUpdateRequest;
import com.dev.java.learnspringjpa.model.request.update.UserUpdateRequest;
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
    public GeneralResponse<Object> getAll(){
        List<UserEntity> datas = userService.getAll();
        return new GeneralResponse<>(200, "Success", "Success get data user", datas);
    }

    @PostMapping("/save")
    public GeneralResponse<Object> save(@RequestBody UserSaveRequest request){
        return userService.save(request);
    }

    @GetMapping("/get-by-id")
    public GeneralResponse<Object> getById(@RequestParam Long id){
        UserEntity user = userService.getById(id);
        if (user.getId() != null){
            return new GeneralResponse<>(200, "Success", "Success get data user", user);
        }
        return new GeneralResponse<>(100, "Failed", "User with id " + id + " is not found!", null);
    }

    @GetMapping("/get-by-name")
    public GeneralResponse<Object> getByUserName(@RequestParam String userName){
        UserEntity user = userService.getByUserName(userName);
        if (user.getId() != null){
            return new GeneralResponse<>(200, "Success", "Success get data user", user);
        }
        return new GeneralResponse<>(100, "Failed", "User with name " + userName + " is not found!", null);
    }

    @PutMapping("/update")
    public GeneralResponse<Object> update(@RequestBody UserUpdateRequest request){
        return userService.update(request);
    }

    @DeleteMapping("/delete-by-id")
    public GeneralResponse<Object> delete(@RequestParam Long id){
        UserEntity user = userService.delete(id);
        if (user.getId() != null){
            return new GeneralResponse<>(200, "Success", "Success delete data user", user);
        }
        return new GeneralResponse<>(100, "Failed", "User with id " + id + " is not found!", null);
    }
}
