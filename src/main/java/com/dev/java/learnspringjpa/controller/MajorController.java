package com.dev.java.learnspringjpa.controller;

import com.dev.java.learnspringjpa.entity.MajorEntity;
import com.dev.java.learnspringjpa.model.request.save.MajorSaveRequest;
import com.dev.java.learnspringjpa.model.request.update.MajorUpdateRequest;
import com.dev.java.learnspringjpa.model.response.GeneralResponse;
import com.dev.java.learnspringjpa.services.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/major")
public class MajorController {
    @Autowired
    private MajorService majorService;
    @GetMapping("/get-all")
    public GeneralResponse<Object> getAll(){
        List<MajorEntity> datas = majorService.getAll();
        return new GeneralResponse<>(200, "Success", "Success get data major", datas);
    }

    @PostMapping("/save")
    public GeneralResponse<Object> save(@RequestBody MajorSaveRequest request){
        return majorService.save(request);
    }

    @GetMapping("/get-by-id")
    public GeneralResponse<Object> getById(@RequestParam Long id){
        MajorEntity major = majorService.getById(id);
        if (major.getId() != null){
            return new GeneralResponse<>(200, "Success", "Success get data major", major);
        }
        return new GeneralResponse<>(100, "Failed", "Major with id " + id + " is not found!", null);
    }

    @GetMapping("/get-by-name")
    public GeneralResponse<Object> getByName(@RequestParam String name){
        MajorEntity major = majorService.getByName(name);
        if (major.getId() != null){
            return new GeneralResponse<>(200, "Success", "Success get data major", major);
        }
        return new GeneralResponse<>(100, "Failed", "Major with name " + name + " is not found!", null);
    }

    @PutMapping("/update")
    public GeneralResponse<Object> update(@RequestBody MajorUpdateRequest request){
        return majorService.update(request);
    }

    @DeleteMapping("/delete-by-id")
    public GeneralResponse<Object> delete(@RequestParam Long id){
        MajorEntity major = majorService.delete(id);
        if (major.getId() != null){
            return new GeneralResponse<>(200, "Success", "Success delete data major", major);
        }
        return new GeneralResponse<>(100, "Failed", "Major with id " + id + " is not found!", null);
    }
}