package hva.ewa.Entrepreneurship.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hva.ewa.Entrepreneurship.IdClass.ResultId;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "result")
@IdClass(ResultId.class)
public class Result implements Serializable {

    @Id
    @NotNull
    private Integer competence_id;

    @Id
    @NotNull
    private Integer user_id;

//    @Id
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    @JsonIgnore
//    private User user_id;
//
//    @Id
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "competence_id")
//    @JsonIgnore
//    private Competence competence_id;

    @NotNull
    private Double score;

//    public User getUser_id() {
//        return user_id;
//    }
//
//    public void setUser_id(User user_id) {
//        this.user_id = user_id;
//    }
//
//    public Competence getCompetence_id() {
//        return competence_id;
//    }
//
//    public void setCompetence_id(Competence competence_id) {
//        this.competence_id = competence_id;
//    }


    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getCompetence_id() {
        return competence_id;
    }

    public void setCompetence_id(Integer competence_id) {
        this.competence_id = competence_id;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
