package group4.todo_program_kaya.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "todos")
public class Todo {

    @jakarta.persistence.Id //기본키 설정
    private long id;
    private String title;
    private String content;
    private LocalDateTime date;
    private boolean completed;

    protected Todo(){ //JPA가 구현을 강제하는 기본생성자
    }

    public Todo(String title, String content, long id){
        this.title = title;
        this.content = content;
        this.date = LocalDateTime.now();
        this.id = id;
        this.completed = false;
    }


    public Long getId() { return this.id; }
    public String getTitle() { return this.title; }
    public String getContent() { return this.content; }
    public LocalDateTime getDate() { return this.date; }
    public boolean isCompleted() { return this.completed; }
    public boolean onOffCompleted() {
        if (this.completed == false) {
            this.completed = true;
            return true;
        } else {
            this.completed = false;
            return false;
        }
    }


}
