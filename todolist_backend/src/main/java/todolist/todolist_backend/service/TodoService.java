package todolist.todolist_backend.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import todolist.todolist_backend.entities.Todo;
import todolist.todolist_backend.exception.EntityNotFoundException;
import todolist.todolist_backend.repositories.TodoRepository;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    /**
     * Method to get all todos
     * 
     * @return
     */
    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }

    /**
     * Method to get a todo by id
     * 
     * @param id
     * @return the todo
     */
    public Todo findById(Long id) {
        return todoRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    /**
     * Method to create a todo
     * 
     * @param todo
     * @return
     */
    public Todo create(Todo todo) {
        return todoRepository.save(todo);
    }

    /**
     * Method to update a todo
     * 
     * @param id
     * @param todo
     * @return the updated todo
     */
    public Todo update(Long id, Todo todo) {
        Todo todoToUpdate = todoRepository.findById(id).get();
        todoToUpdate.setTitle(todo.getTitle());
        todoToUpdate.setDescription(todo.getDescription());
        todoToUpdate.setDate(todo.getDate());
        todoToUpdate.setCompleted(todo.getCompleted());
        return todoRepository.save(todoToUpdate);
    }

    /**
     * Method to delete a todo
     * 
     * @param id
     */
    public void delete(Long id) {
        todoRepository.deleteById(id);
    }

}
