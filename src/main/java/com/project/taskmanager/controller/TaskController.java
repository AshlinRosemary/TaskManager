package com.project.taskmanager.controller;

import com.project.taskmanager.dto.TasksDto;
import com.project.taskmanager.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/tasks")
@AllArgsConstructor
public class TaskController {
    private TaskService taskService;


    //Build AddTask rest api
    @PostMapping
    public ResponseEntity<TasksDto> addTask(@RequestBody TasksDto tasksDto){
        TasksDto savedTask=taskService.addTask(tasksDto);
        return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
    }
}
