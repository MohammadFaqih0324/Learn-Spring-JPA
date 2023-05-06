package com.dev.java.learnspringjpa.services;

import com.dev.java.learnspringjpa.entity.LessonEntity;
import com.dev.java.learnspringjpa.entity.MajorEntity;
import com.dev.java.learnspringjpa.model.request.LessonSaveRequest;
import com.dev.java.learnspringjpa.model.response.GeneralResponse;
import com.dev.java.learnspringjpa.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LessonService {
    @Autowired
    private LessonRepository repository;
    @Autowired
    private MajorService majorService;

    public GeneralResponse<Object> save(LessonSaveRequest request){
        try {
            MajorEntity major = majorService.getById(request.getMajor());
            if (major.getId() == null){
                return new GeneralResponse<>(100, "Failed", "Failed save lesson, major not found", null);
            }

            LessonEntity lesson = new LessonEntity(request.getName(), request.getIsActived(), major);
            repository.save(lesson);
            return new GeneralResponse<>(200, "Success", "Success save lesson", lesson);
        }catch (Exception e){
            System.out.println("failed save lesson with error " + e);
            return new GeneralResponse<>(300, "Failed", e.getMessage(), null);
        }
    }

    public List<LessonEntity> getAll(){
        List<LessonEntity> datas = null;
        try {
            datas = repository.findAll();
        }catch (Exception e){
            System.out.println("failed get data LessonEntity by id with error : " + e.getMessage());
        }
        return datas;
    }

    public LessonEntity getById(Long id){
        LessonEntity data = new LessonEntity();
        try{
            Optional<LessonEntity> optional = repository.findById(id);
            if (optional.isPresent()){
                data = optional.get();
            }
        }catch (Exception e){
            System.out.println("failed get data LessonEntity by id with error : " + e.getMessage());
        }
        return data;
    }

    public List<LessonEntity> getByName(String name){
        List<LessonEntity> data = new ArrayList<>();
        try{
           data = repository.findByName(name);
        }catch (Exception e){
            System.out.println("failed get data LessonEntity by name with error : " + e.getMessage());
            e.printStackTrace();
        }
        return data;
    }

    public LessonEntity update(Long id, LessonEntity lessonEntity){
        LessonEntity data = new LessonEntity();
        try {
            LessonEntity dataFromDb = this.getById(id);
            if (dataFromDb.getId() != null){
                dataFromDb.setUpdatedBy(lessonEntity.getUpdatedBy());
                dataFromDb.setName(lessonEntity.getName());
                dataFromDb.setIsActived(lessonEntity.getIsActived());
                dataFromDb.setMajor(lessonEntity.getMajor());
                data = repository.save(dataFromDb);
            }
        }catch (Exception e){
            System.out.println("failed get data LessonEntity by name with error : " + e);
        }
        return  data;
    }

    public LessonEntity delete(Long id){
        LessonEntity data = new LessonEntity();
        try {
            LessonEntity dataFromDb = this.getById(id);
            if(dataFromDb.getId() != null){
                repository.delete(dataFromDb);
                data = dataFromDb;
            }else {
                System.out.println("failed delete data lesson, id lesson " + id + " is not found");
            }
        } catch (Exception e){
            System.out.println("failed get data LessonEntity by name with error : " + e);
        }
        return data;
    }
}