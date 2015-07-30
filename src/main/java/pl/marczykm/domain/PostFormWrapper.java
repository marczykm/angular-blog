package pl.marczykm.domain;

/**
 * Created by mmarczyk on 2015-07-23.
 */
public class PostFormWrapper {
    private String title;
    private String content;

    public PostFormWrapper() {
    }

    public PostFormWrapper(String title, String content) {
        this.title = title;
        this.content = content;
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

}
