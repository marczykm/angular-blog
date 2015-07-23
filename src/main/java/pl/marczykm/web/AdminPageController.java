package pl.marczykm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.marczykm.domain.Post;
import pl.marczykm.domain.PostFormWrapper;
import pl.marczykm.service.PostService;

/**
 * Created by marcin on 21.07.15.
 */
@Controller
@RequestMapping("/admin")
public class AdminPageController {

    @Autowired
    PostService postService;

    @RequestMapping
    public String adminMainPage(){
        return "admin";
    }

    @RequestMapping("/create")
    public String adminCreatePage(){
        return "create";
    }

    @RequestMapping("/posts")
    public String adminManagePostsPage(){
        return "manage";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String adminSavePostPage(@ModelAttribute PostFormWrapper postFormWrapper, Model model) {
        Post post = new Post();
        post.setTitle(postFormWrapper.getTitle());
        post.setContent(postFormWrapper.getContent());
        post.setAuthor("");
        post.setPhoto(postFormWrapper.getPhoto());
        post.setActive(true);

        postService.savePost(post);

        return "savePostStatus";
    }


}
