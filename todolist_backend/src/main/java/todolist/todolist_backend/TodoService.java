package todolist.todolist_backend;
import org.springframework.stereotype.Service;

public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    // use todoRepository to perform database operations...

}
