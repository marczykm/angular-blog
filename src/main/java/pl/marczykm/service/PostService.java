package pl.marczykm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.marczykm.domain.Post;
import pl.marczykm.domain.PostRepository;

import java.util.List;

/**
 * Created by MMARCZYK on 2015-07-08.
 */
@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post findPostByTitle(String title){
        return postRepository.findPostByTitle(title);
    }

    public List<Post> findAllPosts(){
        return postRepository.findAllPosts();
    }
}