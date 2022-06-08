package sprinter;

import sprinter.service.ArticleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class ArticleServiceTest {

    @Autowired
    ArticleService articleService;

    @Test
    @Transactional
    public void testNewArticle() {

    }

    @Test
    @Transactional
    public void testGetArticle() {

    }

    @Test
    @Transactional
    public void testDeleteArticle() {

    }

    @Test
    @Transactional
    public void testModifyArticle() {

    }
}
