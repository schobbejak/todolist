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
}

