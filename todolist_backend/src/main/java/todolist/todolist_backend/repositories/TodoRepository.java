package todolist.todolist_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import todolist.todolist_backend.entities.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}