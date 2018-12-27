package hva.ewa.Entrepreneurship.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Does auto increment checked
    private Integer question_id;

    @NotNull
    @Size(max = 255)
    private String description_text;

    @NotNull
    private Integer competence_id;

//    @ManyToOne
//    @JoinColumn(name = "competence_id", nullable = false)
//    @JsonIgnore
//    private Competence competence_id;
//
//    public Competence getCompetence_id() {
//        return competence_id;
//    }
//
//    public void setCompetence_id(Competence competence_id) {
//        this.competence_id = competence_id;
//    }


    public Integer getCompetence_id() {
        return competence_id;
    }

    public void setCompetence_id(Integer competence_id) {
        this.competence_id = competence_id;
    }

    public Integer getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(Integer question_id) {
        this.question_id = question_id;
    }

    public String getDescription_text() {
        return description_text;
    }

    public void setDescription_text(String description_text) {
        this.description_text = description_text;
    }
}
