package sprinter.model;

import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {
    Article findByCode(String code);
}
