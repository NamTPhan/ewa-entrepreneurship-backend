package hva.ewa.Entrepreneurship.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "khanacademy")
public class KhanAcademyVideo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Size(max = 100)
    private String internal_id;

    @NotNull
    @Size(max = 300)
    private String title;

    @NotNull
    @Size(max = 1000)
    private String description;

    @NotNull
    @Size(max = 300)
    private String icon;

    @NotNull
    @Size(max = 300)
    private String icon_large;

    @NotNull
    @Size(max = 300)
    private String url;

    @NotNull
    private Integer show_on_top;

    @NotNull
    private Integer show_hide;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInternal_id() {
        return internal_id;
    }

    public void setInternal_id(String internal_id) {
        this.internal_id = internal_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIcon_large() {
        return icon_large;
    }

    public void setIcon_large(String icon_large) {
        this.icon_large = icon_large;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getShow_on_top() {
        return show_on_top;
    }

    public void setShow_on_top(Integer show_on_top) {
        this.show_on_top = show_on_top;
    }

    public Integer getShow_hide() {
        return show_hide;
    }

    public void setShow_hide(Integer show_hide) {
        this.show_hide = show_hide;
    }
}
