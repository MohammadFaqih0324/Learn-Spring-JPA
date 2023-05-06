package com.dev.java.learnspringjpa.controller;

import com.dev.java.learnspringjpa.entity.RoleEntity;
import com.dev.java.learnspringjpa.model.request.RoleSaveRequest;
import com.dev.java.learnspringjpa.model.response.GeneralResponse;
import com.dev.java.learnspringjpa.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/get-all")
    public GeneralResponse getAll(){
        List<RoleEntity> datas = roleService.getAll();
        return new GeneralResponse(200, "Success", "Success get data role", datas);
    }

    @PostMapping("/save")
    public GeneralResponse save(@RequestBody RoleSaveRequest request){
        GeneralResponse response = roleService.save(request);
        return response;
    }
}
