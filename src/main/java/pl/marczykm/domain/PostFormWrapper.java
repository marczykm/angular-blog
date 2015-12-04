package pl.marczykm.domain;

/**
 * Created by mmarczyk on 2015-07-23.
 */
public class PostFormWrapper {
    private Long id;
    private String title;
    private byte[] content;

    public PostFormWrapper() {
    }

    public PostFormWrapper(Long id, String title, byte[] content){
        this.title = title;
        this.content = content;
        this.id = id;
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

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

}
