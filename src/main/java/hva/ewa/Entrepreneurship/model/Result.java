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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user_id;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "competence_id")
    @JsonIgnore
    private Competence competence_id;

    @NotNull
    private Double score;

}
