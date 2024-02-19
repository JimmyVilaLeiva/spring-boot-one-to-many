package com.bezkoder.spring.hibernate.onetomany.Services;

import com.bezkoder.spring.hibernate.onetomany.model.Task;
import com.bezkoder.spring.hibernate.onetomany.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task saveTask (Task task){
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks (){
        return taskRepository.findAll();
    }

    public Task findTaskById(long id){
        return taskRepository.findById(id).orElse(null);
    }

}
