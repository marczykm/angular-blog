package pl.marczykm.domain;

import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Created by MMARCZYK on 2015-07-08.
 */
public interface PostRepository extends Repository<Post, Long>{
    Post findById(Long id);
    List<Post> findAllByOrderByCreationDateDesc();
    Post save(Post post);
    void delete(Long id);
}
