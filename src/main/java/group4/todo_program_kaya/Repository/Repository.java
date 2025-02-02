package group4.todo_program_kaya.Repository;

import group4.todo_program_kaya.Model.Todo;

import java.util.ArrayList;
import java.util.Optional;

public interface Repository {
    boolean save(Todo todo);
    Optional<Todo> findTodoById(long Id);
    ArrayList<Todo> getAllTodo();
}
