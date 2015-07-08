package pl.marczykm.domain;

import org.joda.time.DateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
    private String content;

    @NotNull
    private String author;

    @NotNull
    private Date creationDate;

    private boolean active;

    public Post() {
    }

    public Post(String title, String content, String author, boolean active) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.active = active;
        this.creationDate = new Date();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
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
        if (!content.equals(post.content)) return false;
        if (!author.equals(post.author)) return false;
        return creationDate.equals(post.creationDate);

    }

    @Override
    public int hashCode() {
        int result = content.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + creationDate.hashCode();
        result = 31 * result + (active ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Post{" +
                "content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", creationDate=" + creationDate +
                ", active=" + active +
                '}';
    }
}
