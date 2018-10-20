package hva.ewa.Entrepreneurship.entity;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="question")
public class Question {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) // Does auto increment checked
    private Integer id;
    private String description_text;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription_text() {
        return description_text;
    }

    public void setDescription_text(String description_text) {
        this.description_text = description_text;
    }
}
