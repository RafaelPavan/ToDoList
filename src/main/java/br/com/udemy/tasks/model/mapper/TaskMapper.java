package br.com.udemy.tasks.model.mapper;


import br.com.udemy.tasks.model.dtos.TaskDto;
import br.com.udemy.tasks.model.entities.Task;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    public TaskDto toDto(Task task);

    public Task toBusinessObject(TaskDto taskDto);

    public List<TaskDto> toDtoList(List<Task> tasks);
}
