package pl.marczykm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.marczykm.domain.Post;
import pl.marczykm.service.PostService;

import java.util.List;

/**
 * Created by MMARCZYK on 2015-07-08.
 */
@RestController
@RequestMapping("/rest")
public class BlogController {

    @Autowired
    private PostService postService;

    @RequestMapping("/posts")
    public List<Post> getAllPosts(){
        return postService.findAllPosts();
    }

    @RequestMapping("/post")
    public Post getPostBy(@RequestParam Long id){
        return postService.findPostById(id);
    }
}
