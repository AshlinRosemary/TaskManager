package com.project.taskmanager.service.impl;

import com.project.taskmanager.dto.TasksDto;
import com.project.taskmanager.entity.Tasks;
import com.project.taskmanager.repository.TaskRepository;
import com.project.taskmanager.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;
    @Override
    public TasksDto addTask(TasksDto tasksDto) {
        //convert TaskDto to Task JPA entity
        Tasks task=new Tasks();
        task.setTitle(tasksDto.getTitle());
        task.setDescription(tasksDto.getDescription());
        task.setCompleted(tasksDto.isCompleted());
        //Task JPA entity
        Tasks savedTask=taskRepository.save(task);
        //Convert saved Task JPA entity object to TaskDto object
        TasksDto savedTaskDto= new TasksDto();
        savedTaskDto.setId(savedTask.getId());
        savedTaskDto.setTitle(savedTask.getTitle());
        savedTaskDto.setDescription(savedTask.getDescription());
        savedTaskDto.setCompleted(savedTask.isCompleted());
        return savedTaskDto;
    }
}
