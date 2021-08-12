package com.crud.tasks.controller;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/task")
@RequiredArgsConstructor
public class TaskController {

    private final DbService service;
    private final TaskMapper taskMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getTasks")
    public List<TaskDto> getTasks() {
        List<Task> tasks = service.getAllTasks();
        return taskMapper.mapToTaskDtoList(tasks);
    }

    @GetMapping(value = "getTasks/{id}")
    public TaskDto getTask(@PathVariable long id) {
        return taskMapper.mapToTaskDto(service.getTask(id));
    }

    public void deleteTask(Long taskId){
    }

    public TaskDto updateTask(TaskDto taskDto) {
        return new TaskDto(1L, "edited task title", "Test content");
    }

    public void createTask(TaskDto taskDto) {

    }
}
