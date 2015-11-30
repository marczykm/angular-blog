package pl.marczykm.domain;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import pl.marczykm.AngularBlogApplication;

/**
 * Created by MMARCZYK on 2015-11-30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AngularBlogApplication.class)
@WebAppConfiguration
public class PostRepositoryTest {

    @Autowired
    PostRepository repository;

    @Test
    public void findByIdOkIdTest() {
        Post result = repository.findById(1L);
        Assert.assertNotNull(result);
        Assert.assertEquals(new Long(1), result.getId());
    }

    @Test
    public void findByIdOkAuthorTest() {
        Post result = repository.findById(1L);
        Assert.assertNotNull(result);
        Assert.assertEquals("Anna Wróblewska", result.getAuthor());
    }

    @Test
    public void findByIdOkTitleTest() {
        Post result = repository.findById(1L);
        Assert.assertNotNull(result);
        Assert.assertEquals("\"...niech \u015bwiat m\u00f3j si\u0119 zarumieni!\"", result.getTitle());
    }
}
