package com.bezkoder.spring.hibernate.onetomany.controller;

import com.bezkoder.spring.hibernate.onetomany.Services.TaskService;
import com.bezkoder.spring.hibernate.onetomany.Services.UserService;
import com.bezkoder.spring.hibernate.onetomany.exception.ResourceNotFoundException;
import com.bezkoder.spring.hibernate.onetomany.model.Task;
import com.bezkoder.spring.hibernate.onetomany.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/user/{id}/tasks")
    public ResponseEntity<List<Task>> getAllTaskForAUSerById(@PathVariable long id){
        User _user = userService.findUserById(id);

        if( _user == null ){
            throw new ResourceNotFoundException("Not found tasks with id = " + id);
        }

        List<Task> _tasks = taskService.getAllTasksByUser(_user);

        return new ResponseEntity<>(_tasks, HttpStatus.OK);
    }


}
