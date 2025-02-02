package group4.todo_program_kaya.Model;

import java.time.LocalDateTime;

public record TodoDto(Long id, String title, String content, LocalDateTime Date, boolean completed) {

    public static TodoDto fromEntity(Todo todo){ //todo 객체를 받아서 정적 객체로 반환
        return new TodoDto(todo.getId(), todo.getTitle(), todo.getContent(), todo.getDate(), todo.isCompleted());
    }

}
