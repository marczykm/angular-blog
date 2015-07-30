package pl.marczykm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.marczykm.domain.Post;
import pl.marczykm.service.PostService;

import java.util.List;

/**
 * Created by MMARCZYK on 2015-07-08.
 */
@RestController
@RequestMapping("/rest")
public class RestfulController {

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

    @RequestMapping(value = "/post/save", method = RequestMethod.POST)
    public Post savePost(@RequestBody Post post) {
        return postService.savePost(post);
    }

    @RequestMapping("/post/delete")
    public void deletePost(@RequestParam Long id){
        postService.deletePost(id);
    }

    @RequestMapping(value = "/post/create", method = RequestMethod.POST)
    public void createPost(@RequestBody Post post) {
        Post temp = new Post(
            post.getTitle(),//
            post.getContent(),//
            post.getAuthor() == null ? "" : post.getAuthor(),//
            post.isActive(),//
            post.getPhoto()//
        );
        postService.savePost(temp);
    }
}
