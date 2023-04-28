package com.dev.java.learnspringjpa.services;

import com.dev.java.learnspringjpa.entity.LessonEntity;
import com.dev.java.learnspringjpa.entity.RoleEntity;
import com.dev.java.learnspringjpa.entity.UserEntity;
import com.dev.java.learnspringjpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public UserEntity save(String username, String password, Boolean isActived, List<RoleEntity> roles){
        UserEntity user = new UserEntity(username, password, isActived, roles);
        UserEntity response = repository.save(user);
        return response;
    }

    public List<UserEntity> getAll(){
        List<UserEntity> datas;
        datas = repository.findAll();
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

    public UserEntity getByUserName(String userName){
        UserEntity data = new UserEntity();
        try{
            Optional<UserEntity> optional = repository.findByUserName(userName);
            if (optional.isPresent()){
                data = optional.get();
            }
        }catch (Exception e){
            System.out.println("failed get data MajorEntity by username with error : " + e.getMessage());
        }
        return data;
    }

    public UserEntity update(Long id, UserEntity userEntity){
        UserEntity data = new UserEntity();
        try {
            UserEntity dataFromDb = this.getById(id);
            if (dataFromDb.getId() != null){
                dataFromDb.setUpdatedBy(userEntity.getUpdatedBy());
                dataFromDb.setUserName(userEntity.getUserName());
                dataFromDb.setPassword(userEntity.getPassword());
                dataFromDb.setIsActived(userEntity.getIsActived());
                dataFromDb.setRoles(userEntity.getRoles());
                data = repository.save(dataFromDb);
            }
        }catch (Exception e){
            System.out.println("failed get data UserEntity by name with error : " + e);
        }
        return data;
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