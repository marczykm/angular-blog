package pl.marczykm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    public Post findPostById(Long id){
        return postRepository.findById(id);
    }

    public List<Post> findAllPosts(){
        return postRepository.findAllByOrderByCreationDateDesc();
    }

    public Post savePost(Post post){
        return postRepository.save(post);
    }

    public void deletePost(Long id){
        postRepository.delete(id);
    }
}
