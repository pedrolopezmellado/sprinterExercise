package sprinter;

import sprinter.model.Article;
import sprinter.service.ArticleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ArticleServiceTest {

    @Autowired
    ArticleService articleService;

    @Test
    @Transactional
    public void testNewArticle() {

        Article a = new Article("456", "Example", 12.99, 100, "Example description", true);

        Article article = articleService.newArticle(a);

        assertThat(article.getName()).isEqualTo("Example");
        assertThat(article.getPrice()).isEqualTo(12.99);
    }

    @Test
    @Transactional
    public void testGetArticle() {

        Article article = articleService.findByCode("123");

        assertThat(article).isNotNull();
        assertThat(article.getName()).isEqualTo("Nike SB");
        assertThat(article.getDescription()).isEqualTo("Nike Skateboarding, primarily known as Nike SB, is the Nike brand for its line of shoes, clothing, and equipment for skateboarding." );
    }

    @Test
    @Transactional
    public void testDeleteArticle() {

        Article a = new Article("456", "Example", 12.99, 100, "Example description", true);
        Article article = articleService.newArticle(a);

        assertThat(articleService.findByCode(article.getCode())).isNotNull();

        articleService.deleteArticle(article.getCode());

        assertThat(articleService.findByCode(article.getCode())).isNull();
    }

    @Test
    @Transactional
    public void testModifyArticle() {

        Article a = new Article("456", "Example", 12.99, 100, "Example description", true);
        articleService.newArticle(a);

        Article modifiedA = new Article("456", "Example modified", 12.99, 100, "Example description", true);
        articleService.updateArticle(modifiedA);

        Article articleBD = articleService.findByCode("456");

        assertThat(articleBD.getName()).isEqualTo("Example modified");
    }
}
