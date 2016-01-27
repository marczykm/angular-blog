package pl.marczykm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import pl.marczykm.domain.Photo;
import pl.marczykm.domain.Post;
import pl.marczykm.service.PostService;

/**
 * Created by MMARCZYK on 2016-01-27.
 */
@RestController
@RequestMapping("/admin")
@SessionAttributes("post")
public class AdminRestPageController {

    private PostService postService;

    @InitBinder("post")
    public void initBinder(WebDataBinder binder) {
        binder.setDisallowedFields("id");
    }

    @Autowired
    public AdminRestPageController(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping("/addPhoto")
    public void addUploadedPhoto(final Post post, @RequestParam("photoPath") String photoPath) {
        Photo photo = new Photo();
        photo.setPath(photoPath);
        photo.setPost(post);
        post.getPhotos().add(photo);
    }
}
