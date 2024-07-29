package br.com.udemy.tasks.controller;

import br.com.udemy.tasks.model.dtos.TaskDto;
import br.com.udemy.tasks.model.entities.Task;
import br.com.udemy.tasks.model.mapper.TaskMapper;
import br.com.udemy.tasks.service.TaskService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    private final TaskService service;
    private final TaskMapper mapper;

    public TaskController(TaskService service, TaskMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public Mono<List<TaskDto>> getTasks(){
        return service.list()
                .map(mapper::toDtoList);
    }

    @PostMapping
    public Mono<TaskDto> createTask(@RequestBody Task task){
        return service.insert(task)
                .map(mapper::toDto);
    }
}
