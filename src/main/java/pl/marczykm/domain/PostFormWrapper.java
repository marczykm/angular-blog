package pl.marczykm.domain;

/**
 * Created by mmarczyk on 2015-07-23.
 */
public class PostFormWrapper {
    private String title;
    private String content;
    private String photo;

    public PostFormWrapper() {
    }

    public PostFormWrapper(String title, String content, String photo) {
        this.title = title;
        this.content = content;
        this.photo = photo;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
