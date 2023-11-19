@RestController
@RequestMapping("/api/todos")
public class TodoController {
    
    @Autowired
    private TodoRepository todoRepository;

    @GetMapping
    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        return todoRepository.save(todo);
    }

    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable Long id, @RequestBody Todo todo) {
        Todo todoToUpdate = todoRepository.findById(id).get();
        todoToUpdate.setTitle(todo.getTitle());
        todoToUpdate.setDescription(todo.getDescription());
        todoToUpdate.setDate(todo.getDate());
        todoToUpdate.setCompleted(todo.isCompleted());
        return todoRepository.save(todoToUpdate);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoRepository.deleteById(id);
    }
}
