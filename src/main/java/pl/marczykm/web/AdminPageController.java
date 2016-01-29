package pl.marczykm.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.marczykm.domain.Post;
import pl.marczykm.service.ConfigurationService;
import pl.marczykm.service.PostService;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by marcin on 21.07.15.
 */
@Controller
@RequestMapping("/admin")
@SessionAttributes("post")
public class AdminPageController {

    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private PostService postService;

    @Autowired
    private ConfigurationService configurationService;

    @InitBinder("post")
    public void initBinder(WebDataBinder binder) {
        binder.setDisallowedFields("id");
    }

    @RequestMapping
    public String mainPage(){
        return "admin";
    }

    @RequestMapping("/create")
    public String createPage(Model model){
        Post post = new Post();
        model.addAttribute("post", post);
        return "create";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file){
        if (!file.isEmpty()){
            try {
                byte[] bytes = file.getBytes();
                SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMDDHHmmSS");
                String name = sdf.format(new Date()).hashCode() + file.getOriginalFilename();
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(configurationService.getUploadPath()+name));
                stream.write(bytes);
                stream.close();
                return name;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "NOK";
    }

    @RequestMapping("/posts")
    public String managePostsPage(Model model){
        List<Post> posts = postService.findAllPosts();
        model.addAttribute("posts", posts);
        return "manage";
    }

    @RequestMapping("/edit")
    public String editPostPage(@RequestParam Long id, Post post, Model model) {
        if (post == null)
            post = postService.findPostById(id);
        if (post.getId() != id)
            post = postService.findPostById(id);
        model.addAttribute("post", post);

        return "create";
    }

    @RequestMapping("/delete")
    public String deletePostPage(@RequestParam Long id, Model model){
        Post post = postService.findPostById(id);
        model.addAttribute("post", post);
        postService.deletePost(id);

        return "deleteStatus";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String savePostPage(Post post, Model model) {
        if (post.getAuthor() == null){
            post.setAuthor(configurationService.getAuthor());
        }
        postService.savePost(post);
        model.addAttribute("messageTitle", "Success");
        model.addAttribute("messageContent", "Post saved successfully.");

        return "savePostStatus";
    }
}
