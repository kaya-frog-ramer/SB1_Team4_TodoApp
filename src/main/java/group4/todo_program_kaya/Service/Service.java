package group4.todo_program_kaya.Service;

import group4.todo_program_kaya.Model.Todo;
import group4.todo_program_kaya.Model.TodoDto;

import java.util.List;

public interface Service {
    public TodoDto createTodo(String title, String content);
    public List<String> getAllTodo();
    public TodoDto getTodoById(long id);
    public TodoDto changeCompleteStatus(long id);
}
