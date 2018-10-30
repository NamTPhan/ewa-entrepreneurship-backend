package hva.ewa.Entrepreneurship.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "competence")
public class Competence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Does auto increment checked
    private Integer competence_id;

    @NotNull
    @Size(max = 150)
    private String competence;

    @OneToMany(mappedBy = "competenceEntity")
    private Set<Question> question;

    public Integer getCompetence_id() {
        return competence_id;
    }

    public void setCompetence_id(Integer competence_id) {
        this.competence_id = competence_id;
    }

    public String getCompetence() {
        return competence;
    }

    public void setCompetence(String competence) {
        this.competence = competence;
    }
}
