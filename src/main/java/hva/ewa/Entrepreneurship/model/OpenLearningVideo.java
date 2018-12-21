package hva.ewa.Entrepreneurship.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="openlearningvideo")
public class OpenLearningVideo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="openlearningvideo_id")
    private Integer id;

    @Size(max=100000)
    private String internal_id;
    private String title;
    private String description;
    private String icon;
    private String icon_large;
    private String url;
    private Integer show_on_top;
    private Integer show_hide;
    private String competences;
    private Integer deleted;

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

    public String getCompetences() {
        return competences;
    }

    public void setCompetences(String competences) {
        this.competences = competences;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
}
