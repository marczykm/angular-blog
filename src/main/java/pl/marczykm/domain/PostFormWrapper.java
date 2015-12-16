package pl.marczykm.domain;

/**
 * Created by mmarczyk on 2015-07-23.
 */
public class PostFormWrapper {
    private Long id;
    private String title;
    private String content;
    private String images;

    public PostFormWrapper() {
    }

    public PostFormWrapper(Long id, String title, String content, String images){
        this.title = title;
        this.content = content;
        this.id = id;
        this.images = images;
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
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}
