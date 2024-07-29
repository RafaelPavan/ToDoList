package br.com.udemy.tasks.model.entities;

import br.com.udemy.tasks.model.enums.TaskState;
import br.com.udemy.tasks.service.TaskService;
import lombok.*;
import org.springframework.data.annotation.Id;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id
    private String id;
    private String title;
    private String description;
    private int priority;
    private TaskState state;

    public Task insert() {
        return Task.builder()
                .title(this.title)
                .description(this.description)
                .priority(this.priority)
                .state(TaskState.INSERT)
                .build();
    }
}
