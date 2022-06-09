package sprinter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sprinter.model.Article;
import sprinter.model.ArticleRepository;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ArticleRepositoryTest {
    @Autowired
    ArticleRepository articleRepository;

    @Test
    public void createArticle() throws Exception {

        Article article = new Article("456", "Example", 12.99, 100, "Example description", true);

        assertThat(article.getName()).isEqualTo("Example");
        assertThat(article.getPrice()).isEqualTo(12.99);
    }

    @Test
    public void checkEqualityArticle() {

        Article article = new Article("456", "Example1", 12.95, 100, "Example1", true);
        Article article2 = new Article("456", "Example1", 12.95, 100, "Example1", true);
        Article article3 = new Article("789", "Example2", 13.95, 110, "Example2", true);

        assertThat(article).isNotEqualTo(article3);
        assertThat(article).isEqualTo(article2);

        article.setId(1L);
        article2.setId(1L);
        article3.setId(2L);

        assertThat(article).isEqualTo(article2);
        assertThat(article2).isNotEqualTo(article3);
    }

    @Test
    public void checkItem() {

        Article article = articleRepository.findById(1L).orElse(null);

        assertThat(article).isNotNull();
        assertThat(article.getId()).isEqualTo(1L);
        assertThat(article.getName()).isEqualTo("Nike SB");
        assertThat(article.getDescription()).isEqualTo("Nike Skateboarding, primarily known as Nike SB, is the Nike brand for its line of shoes, clothing, and equipment for skateboarding." );
    }
}
