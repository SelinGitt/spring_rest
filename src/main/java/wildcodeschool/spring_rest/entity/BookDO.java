package wildcodeschool.spring_rest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "book")
public class BookDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String author;
    private String description;

    /**
     * Constructor
     */
    public BookDO() {
        // empty
    }

    /**
     * Getter for id
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for id
     *
     * @param id the id to set
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * Getter for title
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setter for title
     *
     * @param title the title to set
     */
    public void setTitle(final String title) {
        this.title = title;
    }

    /**
     * Getter for author
     *
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Setter for author
     *
     * @param author the author to set
     */
    public void setAuthor(final String author) {
        this.author = author;
    }

    /**
     * Getter for description
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter for description
     *
     * @param description the description to set
     */
    public void setDescription(final String description) {
        this.description = description;
    }

}