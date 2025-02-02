package group4.todo_program_kaya.Service;

import group4.todo_program_kaya.Model.Todo;
import group4.todo_program_kaya.Model.TodoDto;
import group4.todo_program_kaya.Repository.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class JpaTodoService implements Service{
    private Repository repository;
    long id = 0;

    public JpaTodoService(Repository repository){
        this.repository = repository;
    }

    @Override
    public TodoDto createTodo(String title, String content){
        if(title == null || title.isEmpty() || content == null || content.isEmpty()){
            return null;
        }
        this.id += 1;
        Todo newTodo = new Todo(title, content, this.id);
        repository.save(newTodo);
        return TodoDto.fromEntity(newTodo);
    };

    @Override
    public List<String> getAllTodo(){
        return repository.getAllTodo().stream().map(todo->TodoDto.fromEntity(todo).title()).collect(Collectors.toList());
    };

    @Override
    public TodoDto getTodoById(long id){
        if (id < 0){
            return null;
        }
        return repository.findTodoById(id).map(TodoDto :: fromEntity).orElse(null);
    };

    @Override
    public TodoDto changeCompleteStatus(long id){
        if (id < 0){
            return null;
        }
        repository.findTodoById(id).map(todo->todo.onOffCompleted());
        return repository.findTodoById(id).map(TodoDto :: fromEntity).orElse(null);
    }

}
