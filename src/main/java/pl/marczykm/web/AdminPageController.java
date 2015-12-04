package pl.marczykm.web;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.marczykm.domain.Post;
import pl.marczykm.domain.PostFormWrapper;
import pl.marczykm.service.PostService;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

/**
 * Created by marcin on 21.07.15.
 */
@Controller
@RequestMapping("/admin")
public class AdminPageController {

    private Logger logger = Logger.getLogger(this.getClass());

    @Value("${blog.author}")
    private String author;

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
    public String adminManagePostsPage(Model model){
        List<Post> posts = postService.findAllPosts();
        model.addAttribute("posts", posts);
        return "manage";
    }

    @RequestMapping("/delete")
    public String adminDeletePostPage(@RequestParam Long id, Model model){
        Post post = postService.findPostById(id);
        model.addAttribute("post", post);
        postService.deletePost(id);

        return "deleteStatus";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String adminSavePostPage(
            @ModelAttribute PostFormWrapper postFormWrapper,
            Model model) {

        Post post = new Post();
        post.setTitle(postFormWrapper.getTitle());
        post.setContent(postFormWrapper.getContent());
        post.setAuthor(author);
        post.setActive(true);

        postService.savePost(post);
        model.addAttribute("messageTitle", "Success");
        model.addAttribute("messageContent", "Post created successfully.");

        return "savePostStatus";
    }
}
