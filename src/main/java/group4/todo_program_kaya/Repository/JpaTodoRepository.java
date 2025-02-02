package group4.todo_program_kaya.Repository;
import group4.todo_program_kaya.Model.Todo;

import java.util.ArrayList;
import java.util.Optional;

@org.springframework.stereotype.Repository
public class JpaTodoRepository implements Repository{

    ArrayList<Todo> todoList = new ArrayList<Todo>();


    @Override
    public boolean save(Todo todo){
        if (todo == null){
            return false;
        }
        todoList.add(todo);
        return true;
    }

    @Override
    public Optional<Todo> findTodoById(long id){
        if (id < 0){
            return null;
        }
        return todoList.stream().filter(todo -> todo.getId()==id).findFirst();
    }

    @Override
    public ArrayList<Todo> getAllTodo(){
        return todoList;
    };
}





