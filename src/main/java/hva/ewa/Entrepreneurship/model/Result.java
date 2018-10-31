package hva.ewa.Entrepreneurship.model;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="result")
public class Result {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer result_id;
}
