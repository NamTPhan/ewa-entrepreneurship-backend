package hva.ewa.Entrepreneurship.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "additional_videos")
public class AdditionalVideos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Does auto increment checked
    private Integer id;

    @NotNull
    @Size(max = 255)
    private String title;

    @NotNull
    @Size(max = 255)
    private String description;

    @NotNull
    @Size(max = 255)
    private String url;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }
}
