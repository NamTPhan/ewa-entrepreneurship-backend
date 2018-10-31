package hva.ewa.Entrepreneurship.entity;

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
    private String descriptiontext;

//    @Column(insertable = false, updatable = false)
    @NotNull
    private Integer competence_id;

//    @ManyToOne
//    @JoinColumn(name = "competence_id", nullable = false)
//    private Competence competenceEntity;
//
//    public Competence getCompetenceEntity() {
//        return competenceEntity;
//    }
//
//    public void setCompetenceEntity(Competence competenceEntity) {
//        this.competenceEntity = competenceEntity;
//    }

    public Integer getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(Integer question_id) {
        this.question_id = question_id;
    }

    public String getDescriptiontext() {
        return descriptiontext;
    }

    public void setDescriptiontext(String descriptiontext) {
        this.descriptiontext = descriptiontext;
    }

    public Integer getCompetence_id() {
        return competence_id;
    }

    public void setCompetence_id(Integer competence_id) {
        this.competence_id = competence_id;
    }
}
