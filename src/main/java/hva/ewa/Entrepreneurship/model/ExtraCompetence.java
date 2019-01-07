package hva.ewa.Entrepreneurship.model;

import hva.ewa.Entrepreneurship.IdClass.ExtraCompetenceId;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "extra_competence")
@IdClass(ExtraCompetenceId.class)
public class ExtraCompetence implements Serializable {

    @Id
    @NotNull
    @Size(max = 100)
    private String competence;

    @Id
    @NotNull
    @Size(max = 100)
    private String date_added;

    @Id
    @NotNull
    private Integer user_id;

    public String getCompetence() {
        return competence;
    }

    public void setCompetence(String competence) {
        this.competence = competence;
    }

    public String getDate_added() {
        return date_added;
    }

    public void setDate_added(String date_added) {
        this.date_added = date_added;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}
