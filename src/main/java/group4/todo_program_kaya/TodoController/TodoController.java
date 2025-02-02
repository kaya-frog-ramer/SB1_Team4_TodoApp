package group4.todo_program_kaya.TodoController;

import group4.todo_program_kaya.Model.TodoDto;
import group4.todo_program_kaya.Service.JpaTodoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private final JpaTodoService todoService;


    public TodoController(JpaTodoService todoService) {
        this.todoService = todoService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public TodoDto createTodo(@RequestParam String title, @RequestParam String content) {
        return todoService.createTodo(title, content);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping("/list")
    public List<String> getAllTodos() {
        return todoService.getAllTodo();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping("/{id}")
    public TodoDto getTodoById(@PathVariable Long id) {
        return todoService.getTodoById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{id}")
    public TodoDto changeCompleteStatus(@PathVariable Long id){
        todoService.changeCompleteStatus(id);
        return todoService.getTodoById(id);
    }
}
