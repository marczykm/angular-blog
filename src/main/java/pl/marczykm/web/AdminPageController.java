package pl.marczykm.web;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

/**
 * Created by marcin on 21.07.15.
 */
@Controller
@RequestMapping("/admin")
public class AdminPageController {

    Logger logger = Logger.getLogger(this.getClass());

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
            @RequestParam("background-image") MultipartFile file,
            Model model) {

        boolean uploadStatus = false;
        String name = DigestUtils.sha1Hex(new Date().toString()) + "." + extractExtension(file.getOriginalFilename());

        File fileU = new File("/root/apache-tomcat-8.0.24/angular-blog-0.0.2/ROOT/WEB-INF/classes/public/uploads/" + name);

        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(fileU));
                stream.write(bytes);
                stream.close();

                uploadStatus = true;
                logger.info("Upload successful: " + fileU.getAbsolutePath());
            } catch (Exception e) {
                uploadStatus = false;
                logger.info("Upload failed: " + fileU.getAbsolutePath());
            }
        } else {
            uploadStatus = false;
            logger.info("Upload failed: " + fileU.getAbsolutePath());
        }


        if (uploadStatus) {
            Post post = new Post();
            post.setTitle(postFormWrapper.getTitle());
            post.setContent(postFormWrapper.getContent());
            post.setAuthor("");
            post.setActive(true);
            post.setPhoto(name);

            postService.savePost(post);
            model.addAttribute("messageTitle", "Success");
            model.addAttribute("messageContent", "Post created successfully.");
        }

        if (!uploadStatus){
            model.addAttribute("messageTitle", "Failed");
            model.addAttribute("messageContent", "Failed to create post.");
        }

        return "savePostStatus";
    }

    private String extractExtension(String filename) {
        String[] splitted = filename.split("\\.");
        return splitted[splitted.length-1];
    }


}
