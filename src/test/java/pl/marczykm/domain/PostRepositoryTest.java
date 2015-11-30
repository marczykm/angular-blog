package pl.marczykm.domain;


import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import pl.marczykm.AngularBlogApplication;

import java.util.List;

/**
 * Created by MMARCZYK on 2015-11-30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AngularBlogApplication.class)
@WebAppConfiguration
@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = {"drop.sql", "create.sql", "insert_posts.sql"})
public class PostRepositoryTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Autowired
    PostRepository repository;

    @Test
    public void findByIdOkIdTest() {
        Post result = repository.findById(1L);
        Assert.assertEquals(new Long(1), result.getId());
    }

    @Test
    public void findByIdOkAuthorTest() {
        Post result = repository.findById(1L);
        Assert.assertEquals("Anna Wróblewska", result.getAuthor());
    }

    @Test
    public void findByIdOkTitleTest() {
        Post result = repository.findById(1L);
        Assert.assertEquals("\"...niech \u015bwiat m\u00f3j si\u0119 zarumieni!\"", result.getTitle());
    }

    @Test
    public void findByIdNullTest() {
        Post result = repository.findById(6L);
        Assert.assertNull(result);
    }

    @Test
    public void findAllTest() {
        List<Post> result = repository.findAllByOrderByCreationDateDesc();
        Assert.assertEquals(5, result.size());
    }

    @Test
    public void deleteFoundId(){
        repository.delete(1L);
        List<Post> result = repository.findAllByOrderByCreationDateDesc();
        Assert.assertEquals(4, result.size());
    }

    @Test
    public void deleteNotFoundId() {
        exception.expect(EmptyResultDataAccessException.class);
        repository.delete(6L);
        List<Post> result = repository.findAllByOrderByCreationDateDesc();
        Assert.assertEquals(5, result.size());
    }


}
