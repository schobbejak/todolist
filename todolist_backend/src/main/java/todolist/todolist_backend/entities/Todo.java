package todolist.todolist_backend.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Todo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String date;

    private boolean completed;

    public Todo() {   
    }

    public Todo(String title, String description, String date, boolean completed) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.completed = completed;
    }


    /**
     * Method to get the id of the todo
     * 
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Method to get the title of the todo
     * 
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Method to get the description of the todo
     * 
     * @return the description
     */
    public String getDescription() { 
        return description; 
    }

    /**
     * Method to get the date of the todo
     * 
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * Method to get the completed status of the todo
     * 
     * @return the completed status
     */
    public boolean getCompleted() {
        return completed;
    }

    /**
     * Method to set the id of the todo
     * 
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Method to set the title of the todo
     * 
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Method to set the description of the todo
     * 
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Method to set the date of the todo
     * 
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Method to set the completed status of the todo
     * 
     * @param completed the completed status to set
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    /**
     * Method to check if two todos are equal
     * 
     * @param obj the object to compare to
     * @return true if the todos are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Todo)) return false;
        Todo todo = (Todo) obj;
        return todo.getId() == this.getId() &&
            todo.getTitle().equals(this.getTitle()) &&
            todo.getDescription().equals(this.getDescription()) &&
            todo.getDate().equals(this.getDate()) &&
            todo.getCompleted() == this.getCompleted();
    }

    /**
     * Method to get the hashcode of the todo
     * 
     * @return the hashcode of the todo
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.getId(), this.getTitle(), this.getDescription(), this.getDate(), this.getCompleted());
    }

    /**
     * Method to get the string representation of the todo
     * 
     * @return the string representation of the todo
     */
    @Override
    public String toString() {
        return "Todo: " + this.getId() + ", " + this.getTitle() + ", " + this.getDescription() + ", " + this.getDate() + ", " + this.getCompleted();
    }

}

