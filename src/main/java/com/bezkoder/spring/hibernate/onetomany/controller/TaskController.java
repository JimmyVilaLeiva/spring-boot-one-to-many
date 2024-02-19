package com.bezkoder.spring.hibernate.onetomany.controller;

import com.bezkoder.spring.hibernate.onetomany.Services.TaskService;
import com.bezkoder.spring.hibernate.onetomany.Services.UserService;
import com.bezkoder.spring.hibernate.onetomany.model.Comment;
import com.bezkoder.spring.hibernate.onetomany.model.Task;
import com.bezkoder.spring.hibernate.onetomany.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @PostMapping("/user/{id}/tasks")
    public ResponseEntity<Task> addNewUserToDb(@RequestBody Task task, @PathVariable("id") long id){

        User _user =userService.findUserById(id);
        task.setUser(_user);
        taskService.saveTask(task);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
