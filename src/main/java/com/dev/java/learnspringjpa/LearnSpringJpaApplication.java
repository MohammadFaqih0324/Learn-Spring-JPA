package com.dev.java.learnspringjpa;

import com.dev.java.learnspringjpa.entity.*;
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

        List<CourseEntity> courseEntities = new ArrayList<>();
        courseEntities.add(course1);
        courseEntities.add(course2);
        courseEntities.add(course3);

        // STUDENT
        StudentService studentService = context.getBean(StudentService.class);
        studentService.save("Vivi", 26, major1, address1, courseEntities);
        studentService.save("Faqih", 24, major2, address2, courseEntities);
        studentService.save("Jafar", 26, major3, address3, courseEntities);
        studentService.save("Nabhan", 1, major3, address4, courseEntities);

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
        lessonService.save("Final Project", true, major3);

        // ROLE
        RoleService roleService = context.getBean(RoleService.class);
        RoleEntity role1 = roleService.save("ADMIN", true);
        RoleEntity role2 = roleService.save("USER", true);
        RoleEntity role3 = roleService.save("GUEST", true);

        List<RoleEntity> roleEntities = new ArrayList<>();
        roleEntities.add(role1);
        roleEntities.add(role2);
        roleEntities.add(role3);

        // USER
        UserService userService = context.getBean(UserService.class);
        userService.save("Jhon Doe", "password123", true, roleEntities);
        userService.save("Jane Smith", "password456", true, roleEntities);
        userService.save("Bob Jhonson", "password789", true, roleEntities);

        // -- GET --

        // ADDRESS

        // FIND ALL
        List<AddressEntity> addressEntityList = addressService.getAll();
        addressEntityList.forEach(addressEntity -> {
            System.out.println(addressEntity.getId());
        });

        // FIND BY ID
        AddressEntity getByAddressId = addressService.getById(1L);
        System.out.println("ini hasil dari getById id = " + getByAddressId.getId());

        // FIND BY ADDRESS
        AddressEntity getByAddress = addressService.getByAddress("Karawang");
        System.out.println("ini hasil dari getByAddress with id = " + getByAddress.getId() + " alamatnya = " + getByAddress.getAddress());


        // MAJOR

        // FIND ALL
        List<MajorEntity> majorEntityList = majorService.getAll();
        majorEntityList.forEach(majorEntity -> {
            System.out.println(majorEntity.getId());
        });

        // FIND BY ID
        MajorEntity getByMajorId = majorService.getById(1L);
        System.out.println("ini hasil dari getById id = " + getByMajorId.getId());

        // FIND BY NAME
        MajorEntity getByMajorName = majorService.getByName("Backend Developer");
        System.out.println("ini hasil dari getByName with id = " + getByMajorName.getId() + " jurusan = " + getByMajorName.getName());


        // COURSE

        // FIND ALL
        List<CourseEntity> courseEntityList = courseService.getAll();
        courseEntityList.forEach(courseEntity -> {
            System.out.println(courseEntity.getId());
        });

        // FIND BY ID
        CourseEntity getByCourseId = courseService.getById(1L);
        System.out.println("ini hasil dari getById id = " + getByCourseId.getId());

        // FIND BY NAME
        CourseEntity getByCourseName = courseService.getByName("Backend Developer");
        System.out.println("ini hasil dari getByName with id = " + getByCourseName.getId() + " kursus = " + getByCourseName.getName());


        // STUDENT

        // FIND ALL
        List<StudentEntity> studentEntityList = studentService.getAll();
        studentEntityList.forEach(studentEntity -> {
            System.out.println(studentEntity.getId());
        });

        // FIND BY ID
        StudentEntity getByStudentId = studentService.getById(1L);
        System.out.println("ini hasil dari getById id = " + getByStudentId.getId());

        // FIND BY NAME
        StudentEntity getByStudentName = studentService.getByName("Vivi");
        System.out.println("ini hasil dari getByName with id = " + getByStudentName.getId() + " student = " + getByStudentName.getName());


        // LESSON

        // FIND ALL
        List<LessonEntity> lessonEntityList = lessonService.getAll();
        lessonEntityList.forEach(lessonEntity -> {
            System.out.println(lessonEntity.getId());
        });

        // FIND BY ID
        LessonEntity getByLessonId = lessonService.getById(2L);
        System.out.println("ini hasil dari LessonService getById id = " + getByLessonId.getId());

        // FIND BY NAME
        List<LessonEntity> getByLessonName = lessonService.getByName("Basic Java");
        getByLessonName.forEach(lessonEntity -> {
            System.out.println("ini hasil dari getByName with id = " + lessonEntity.getId() + " lesson = " + lessonEntity.getName());
        });


        // ROLE

        // FIND ALL
        List<RoleEntity> roleEntityList = roleService.getAll();
        roleEntityList.forEach(roleEntity -> {
            System.out.println(roleEntity.getId());
        });

        // FIND BY ID
        RoleEntity getByRoleId = roleService.getById(1L);
        System.out.println("ini hasil dari getById id = " + getByRoleId.getId());

        // FIND BY NAME
        RoleEntity getByRoleName = roleService.getByName("ADMIN");
        System.out.println("ini hasil dari getByName with id = " + getByRoleName.getId() + " role = " + getByRoleName.getName());


        // USER

        // FIND ALL
        List<UserEntity> userEntityList = userService.getAll();
        userEntityList.forEach(userEntity -> {
            System.out.println(userEntity.getId());
        });

        // FIND BY ID
        UserEntity getByUserId = userService.getById(1L);
        System.out.println("ini hasil dari getById id = " + getByUserId.getId());

        // FIND BY USERNAME
        UserEntity getByUserName = userService.getByUserName("Jhon Doe");
        System.out.println("ini hasil dari getByName with id = " + getByUserName.getId() + " username = " + getByUserName.getUserName());

    }
}