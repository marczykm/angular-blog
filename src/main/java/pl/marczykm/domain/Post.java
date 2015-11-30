package pl.marczykm.domain;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by MMARCZYK on 2015-07-08.
 */
@Entity
public class Post {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String title;

    @NotNull
    @Lob
    private byte[] content;

    @NotNull
    private String author;

    @NotNull
    private Date creationDate;

    private boolean active;

    public Post() {
        this.creationDate = new Date();
    }

    public Post(String title, byte[] content, String author, boolean active) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.active = active;
        this.creationDate = new Date();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return new String(content);
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
