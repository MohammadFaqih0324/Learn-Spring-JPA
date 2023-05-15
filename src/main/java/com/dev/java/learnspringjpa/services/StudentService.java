package com.dev.java.learnspringjpa.services;

import com.dev.java.learnspringjpa.entity.AddressEntity;
import com.dev.java.learnspringjpa.entity.CourseEntity;
import com.dev.java.learnspringjpa.entity.MajorEntity;
import com.dev.java.learnspringjpa.entity.StudentEntity;
import com.dev.java.learnspringjpa.model.request.save.StudentSaveRequest;
import com.dev.java.learnspringjpa.model.request.update.StudentUpdateRequest;
import com.dev.java.learnspringjpa.model.response.GeneralResponse;
import com.dev.java.learnspringjpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;
    @Autowired
    private MajorService majorService;
    @Autowired
    private AddressService addressService;
    @Autowired
    public CourseService courseService;

    public GeneralResponse<Object> save(StudentSaveRequest request){
        List<CourseEntity> courseEntities = new ArrayList<>();
        try {
            MajorEntity major = majorService.getById(request.getMajor());
            if (major.getId() == null){
                return new GeneralResponse<>(100, "Failed", "Failed save student, major not found", null);
            }
            AddressEntity address = addressService.getById(request.getAddress());
            if (address.getId() == null){
                return new GeneralResponse<>(100, "Failed", "Failed save student, address not found", null);
            }

            for (Long courseId : request.getCourse()) {
                CourseEntity course = courseService.getById(courseId);
                if (course.getId() == null){
                    return new GeneralResponse<>(100, "Failed", "Failed save student, course not found", null);
                }
                courseEntities.add(course);
            }

            StudentEntity student = new StudentEntity(request.getName(), request.getAge(), major, address, courseEntities);
            repository.save(student);
            return new GeneralResponse<>(200, "Success", "Success save student", student);
        }catch (Exception e){
            System.out.println("failed save student with error " + e);
            return new GeneralResponse<>(300, "Failed", e.getMessage(), null);
        }
    }

    public List<StudentEntity> getAll(){
        List<StudentEntity> datas = new ArrayList<>();
        try {
            datas = repository.findAll();
        }catch (Exception e){
            System.out.println("failed get data StudentEntity by id with error : " + e.getMessage());
        }
        return datas;
    }

    public StudentEntity getById(Long id){
        StudentEntity data = new StudentEntity();
        try{
            Optional<StudentEntity> optional = repository.findById(id);
            if (optional.isPresent()){
                data = optional.get();
            }
        }catch (Exception e){
            System.out.println("failed get data StudentEntity by id with error : " + e.getMessage());
        }
        return data;
    }

    public StudentEntity getByName(String name){
        StudentEntity data = new StudentEntity();
        try{
            Optional<StudentEntity> optional = repository.findByName(name);
            if (optional.isPresent()){
                data =optional.get();
            }
        }catch (Exception e){
            System.out.println("failed get data StudentEntity by name with error : " + e.getMessage());
        }
        return data;
    }

    public GeneralResponse<Object> update(StudentUpdateRequest request) {
        List<CourseEntity> courseEntities = new ArrayList<>();
        try {
            StudentEntity student = this.getById(request.getId());
            if (student.getId() != null){
                // get data and validation
                MajorEntity major = majorService.getById(request.getMajor());
                if (major.getId() == null){
                return new GeneralResponse<>(100, "Failed", "Failed update student, major not found", null);
                }
                AddressEntity address = addressService.getById(request.getAddress());
                if (address.getId() == null){
                return new GeneralResponse<>(100, "Failed", "Failed update student, address not found", null);
                }

                for (Long courseId : request.getCourse()) {
                    CourseEntity course = courseService.getById(courseId);
                    if (course.getId() == null){
                        return new GeneralResponse<>(100, "Failed", "Failed update student, course with id : " + courseId + " not found", null);
                    }
                    courseEntities.add(course);
                }

                student = new StudentEntity(student, request.getUpdateBy(), request.getName(), request.getAge(), major, address, courseEntities);
                repository.save(student);
                return new GeneralResponse<>(200, "Success", "Success update student", student);
            }
        }catch (Exception e){
            System.out.println("failed update student with error " + e);
            return new GeneralResponse<>(300, "Failed", e.getMessage(), null);
        }
        return new GeneralResponse<>(100, "Failed", "Failed update student, student with id : " + request.getId() + " is not found", null);
    }

    public StudentEntity delete(Long id){
        StudentEntity data = new StudentEntity();
        try {
            StudentEntity dataFromDb = this.getById(id);
            if(dataFromDb.getId() != null){
                repository.delete(dataFromDb);
                data = dataFromDb;
            }else {
                System.out.println("failed delete data student, id student " + id + " is not found");
            }
        } catch (Exception e){
            System.out.println("failed get data StudentEntity by name with error : " + e);
        }
        return data;
    }
}