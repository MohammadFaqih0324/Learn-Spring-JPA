package com.dev.java.learnspringjpa.controller;

import com.dev.java.learnspringjpa.entity.MajorEntity;
import com.dev.java.learnspringjpa.model.request.MajorSaveRequest;
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
    public GeneralResponse getAll(){
        List<MajorEntity> datas = majorService.getAll();
        return new GeneralResponse(200, "Success", "Success get data major", datas);
    }

    @PostMapping("/save")
    public GeneralResponse save(@RequestBody MajorSaveRequest request){
        GeneralResponse response = majorService.save(request);
        return response;
    }
}