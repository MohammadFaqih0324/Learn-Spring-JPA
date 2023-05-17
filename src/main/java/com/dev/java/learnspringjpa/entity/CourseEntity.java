package com.dev.java.learnspringjpa.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "COURSE")
public class CourseEntity extends BaseEntity{
    private String name;
    private Boolean isActived;

//    @ManyToMany(mappedBy = "courses")
//    private List<StudentEntity> students;

    public CourseEntity() {
    }

    public CourseEntity(String name, Boolean isActived) {
        this.name = name;
        this.isActived = isActived;
    }

    public CourseEntity(CourseEntity courseEntity, String updateBy, String name, Boolean isActived) {
        super.setId(courseEntity.getId());
        super.setCreatedDate(courseEntity.getCreatedDate());
        super.setCreatedBy(courseEntity.getCreatedBy());
        super.setUpdatedBy(updateBy);
        this.name = name;
        this.isActived = isActived;
    }

    public String toString(){
        return "id = " + this.getId() + " name = " + this.getName();
    }
}