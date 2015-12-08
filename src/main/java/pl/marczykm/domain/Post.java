package pl.marczykm.domain;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;
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
    @Column(columnDefinition="text")
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

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

        if (active != post.active) return false;
        if (id != null ? !id.equals(post.id) : post.id != null) return false;
        if (title != null ? !title.equals(post.title) : post.title != null) return false;
        if (!Arrays.equals(content, post.content)) return false;
        if (author != null ? !author.equals(post.author) : post.author != null) return false;
        return !(creationDate != null ? !creationDate.equals(post.creationDate) : post.creationDate != null);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(content);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (active ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content=" + Arrays.toString(content) +
                ", author='" + author + '\'' +
                ", creationDate=" + creationDate +
                ", active=" + active +
                '}';
    }
}
