package com.dev.java.learnspringjpa;

import com.dev.java.learnspringjpa.entity.AddressEntity;
import com.dev.java.learnspringjpa.entity.CourseEntity;
import com.dev.java.learnspringjpa.entity.MajorEntity;
import com.dev.java.learnspringjpa.entity.RoleEntity;
import com.dev.java.learnspringjpa.services.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class LearnSpringJpaApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(LearnSpringJpaApplication.class, args);

        // ADDRESS
        AddressService addressService = context.getBean(AddressService.class);
        AddressEntity address1 = addressService.save("Karawang");
        AddressEntity address2 = addressService.save("Jakarta");
        AddressEntity address3 = addressService.save("Bandung");
        AddressEntity address4 = addressService.save("Tual");

        // MAJOR
		MajorService majorService = context.getBean(MajorService.class);
		MajorEntity major1 = majorService.save("Backend Developer", true);
		MajorEntity major2 = majorService.save("Frontend Developer", true);
		MajorEntity major3 = majorService.save("Fullstack Developer", true);

        // COURSE
        CourseService courseService = context.getBean(CourseService.class);
        CourseEntity course1 = courseService.save("Backend Developer", true);
        CourseEntity course2 = courseService.save("Frontend Developer", Boolean.TRUE);
        CourseEntity course3 = courseService.save("Fullstack Developer", true);

        List<CourseEntity> courseEntityList = new ArrayList<>();
        courseEntityList.add(course1);
        courseEntityList.add(course2);
        courseEntityList.add(course3);

        // STUDENT
        StudentService studentService = context.getBean(StudentService.class);
        studentService.save("Vivi", 26, major1, address1, courseEntityList);
        studentService.save("Faqih", 24, major2, address2, courseEntityList);
        studentService.save("Jafar", 26, major3, address3, courseEntityList);
        studentService.save("Nabhan", 1, major3, address4, courseEntityList);

        // LESSON
        LessonService lessonService = context.getBean(LessonService.class);
        lessonService.save("Introduction to Programming", true, major1);
        lessonService.save("Basic Java", true, major1);
        lessonService.save("Java Build Automation : Maven", true, major1);
        lessonService.save("Framework : Spring and JPA", true, major1);
        lessonService.save("Framework : Springboot and Spring Security", true, major1);
        lessonService.save("Basic : Html, Css and Javascript", true, major2);
        lessonService.save("Framework : ReactJS", true, major2);
        lessonService.save("Final Project", true, major2);
        lessonService.save("Introduction to Programming", true, major3);
        lessonService.save("Java Build Automation : Maven", true, major3);
        lessonService.save("Framework : Spring and JPA", true, major3);
        lessonService.save("Framework : Springboot and Spring Security", true, major3);
        lessonService.save("Basic : Html, Css and Javascript", true, major3);
        lessonService.save("Basic : Html, Css and Javascript", true, major3);
        lessonService.save("Final Project", true, major3);

        // ROLE
        RoleService roleService = context.getBean(RoleService.class);
        RoleEntity role1 = roleService.save("ADMIN", true);
        RoleEntity role2 = roleService.save("USER", true);
        RoleEntity role3 = roleService.save("GUEST", true);

        List<RoleEntity> roleEntityList = new ArrayList<>();
        roleEntityList.add(role1);
        roleEntityList.add(role2);
        roleEntityList.add(role3);

        // USER
        UserService userService = context.getBean(UserService.class);
        userService.save("Jhon Doe", "password123", true, roleEntityList);
        userService.save("Jane Smith", "password456", true, roleEntityList);
        userService.save("Bob Jhonson", "password789", true, roleEntityList);

//		LessonService lessonService = context.getBean(LessonService.class);
//		lessonService.save();

//      System.out.println(dataAddress1.getId() + " " + dataAddress1.getAddress());
//      System.out.println(dataAddress2.getId() + " " + dataAddress2.getAddress());


//        courseEntityList.forEach(new Consumer<CourseEntity>() {
//            @Override
//            public void accept(CourseEntity courseEntity) {
//                System.out.println(courseEntity.getName());
//            }
//        });
    }
}