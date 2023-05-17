package com.dev.java.learnspringjpa.services;

import com.dev.java.learnspringjpa.entity.*;
import com.dev.java.learnspringjpa.model.request.save.UserSaveRequest;
import com.dev.java.learnspringjpa.model.request.update.UserUpdateRequest;
import com.dev.java.learnspringjpa.model.response.GeneralResponse;
import com.dev.java.learnspringjpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private RoleService roleService;

    public GeneralResponse<Object> save(UserSaveRequest request){
        List<RoleEntity> roleEntities = new ArrayList<>();
        try {
            for (Long roleId : request.getRole()) {
                RoleEntity role = roleService.getById(roleId);
                if (role.getId() == null){
                    return new GeneralResponse<>(100, "Failed", "Failed save user, user not found", null);
                }
                roleEntities.add(role);
            }

            UserEntity user = new UserEntity(request.getUserName(), request.getPassword(), request.getIsActived(), roleEntities);
            repository.save(user);
            return new GeneralResponse<>(200, "Success", "Success save user", user);
        }catch (Exception e){
            System.out.println("failed save user with error " + e);
            return new GeneralResponse<>(300, "Failed", e.getMessage(), null);
        }
    }

    public List<UserEntity> getAll(){
        List<UserEntity> datas = new ArrayList<>();
        try {
            datas = repository.findAll();
        }catch (Exception e){
            System.out.println("failed get data UserEntity by id with error : " + e.getMessage());
        }
        return datas;
    }

    public UserEntity getById(Long id){
        UserEntity data = new UserEntity();
        try{
            Optional<UserEntity> optional = repository.findById(id);
            if (optional.isPresent()){
                data = optional.get();
            }
        }catch (Exception e){
            System.out.println("failed get data MajorEntity by id with error : " + e.getMessage());
        }
        return data;
    }

    public List<UserEntity> getByUserName(String userName){
        List<UserEntity> data = new ArrayList<>();
        try{
            data = repository.findByUserName(userName);
        }catch (Exception e){
            System.out.println("failed get data MajorEntity by username with error : " + e.getMessage());
        }
        return data;
    }

    public GeneralResponse<Object> update(UserUpdateRequest request){
        List<RoleEntity> roleEntities = new ArrayList<>();
        try {
            UserEntity user = this.getById(request.getId());
            if (user.getId() != null){
            for (Long roleId : request.getRole()){
                RoleEntity role = roleService.getById(roleId);
                if (role.getId() == null){
                    return new GeneralResponse<>(100, "Failed", "Failed update user, role with id : " + roleId + " not found", null);
                }
                roleEntities.add(role);
            }

            user = new UserEntity(user, request.getUpdateBy(), request.getUserName(), request.getPassword(), request.getIsActived(), roleEntities);
            repository.save(user);
                return new GeneralResponse<>(200, "Success", "Success update user", user);
            }
        }catch (Exception e){
            System.out.println("failed get data UserEntity by name with error : " + e);
            return new GeneralResponse<>(300, "Failed", e.getMessage(), null);
        }
        return new GeneralResponse<>(100, "Failed", "Failed update user, user with id : " + request.getId() + " is not found", null);
    }

    public UserEntity delete(Long id){
        UserEntity data = new UserEntity();
        try {
            UserEntity dataFromDb = this.getById(id);
            if(dataFromDb.getId() != null){
                repository.delete(dataFromDb);
                data = dataFromDb;
            }else {
                System.out.println("failed delete data user, id user " + id + " is not found");
            }
        } catch (Exception e){
            System.out.println("failed get data UserEntity by name with error : " + e);
        }
        return data;
    }
}