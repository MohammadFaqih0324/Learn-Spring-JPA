package com.dev.java.learnspringjpa.controller;

import com.dev.java.learnspringjpa.entity.AddressEntity;
import com.dev.java.learnspringjpa.entity.MajorEntity;
import com.dev.java.learnspringjpa.entity.RoleEntity;
import com.dev.java.learnspringjpa.model.request.save.RoleSaveRequest;
import com.dev.java.learnspringjpa.model.request.update.AddressUpdateRequest;
import com.dev.java.learnspringjpa.model.request.update.RoleUpdateRequest;
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
    public GeneralResponse<Object> getAll(){
        List<RoleEntity> datas = roleService.getAll();
        return new GeneralResponse<>(200, "Success", "Success get data role", datas);
    }

    @PostMapping("/save")
    public GeneralResponse<Object> save(@RequestBody RoleSaveRequest request){
        return roleService.save(request);
    }

    @GetMapping("/get-by-id")
    public GeneralResponse<Object> getById(@RequestParam Long id){
        RoleEntity role = roleService.getById(id);
        if (role.getId() != null){
            return new GeneralResponse<>(200, "Success", "Success get data by id role", role);
        }
        return new GeneralResponse<>(100, "Failed", "Role with id " + id + " is not found!", null);
    }

    @GetMapping("/get-by-name")
    public GeneralResponse<Object> getByName(@RequestParam String name){
        RoleEntity role = roleService.getByName(name);
        if (role.getId() != null){
            return new GeneralResponse<>(200, "Success", "Success get data role", role);
        }
        return new GeneralResponse<>(100, "Failed", "Role with name " + name + " is not found!", null);
    }

    @PutMapping("/update")
    public GeneralResponse<Object> update(@RequestBody RoleUpdateRequest request){
        return roleService.update(request);
    }

    @DeleteMapping("/delete-by-id")
    public GeneralResponse<Object> delete(@RequestParam Long id){
        RoleEntity role = roleService.delete(id);
        if (role.getId() != null){
            return new GeneralResponse<>(200, "Success", "Success delete data role", role);
        }
        return new GeneralResponse<>(100, "Failed", "Role with id " + id + " is not found!", null);
    }
}