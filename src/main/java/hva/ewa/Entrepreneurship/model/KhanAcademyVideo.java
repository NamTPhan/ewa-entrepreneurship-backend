package hva.ewa.Entrepreneurship.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "khanacademy")
public class KhanAcademyVideo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String internal_id;

    @NotNull
    private String title;

    @NotNull
    private String description;

    @NotNull
    private String icon;

    @NotNull
    private String icon_large;

    @NotNull
    private String url;

    @NotNull
    private Integer showOnTop;

    @NotNull
    private Integer showHide;

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

    public Integer getShowOnTop() {
        return showOnTop;
    }

    public void setShowOnTop(Integer showOnTop) {
        this.showOnTop = showOnTop;
    }

    public Integer getShowHide() {
        return showHide;
    }

    public void setShowHide(Integer showHide) {
        this.showHide = showHide;
    }
}
