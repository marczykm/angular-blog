package pl.marczykm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by MMARCZYK on 2015-12-09.
 */
@Entity
public class Photo {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @ManyToOne
    private Post post;

    @NotNull
    private String path;

    public Photo() {
    }

    public Long getId() {
        return id;
    }

    public String getPath() {
        return path;
    }

    public Post getPost() {
        return post;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
