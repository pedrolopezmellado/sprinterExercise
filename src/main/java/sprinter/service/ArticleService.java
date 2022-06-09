package sprinter.service;

import org.hibernate.exception.ConstraintViolationException;
import sprinter.model.Article;
import sprinter.model.ArticleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArticleService {

    Logger logger = LoggerFactory.getLogger(ArticleService.class);
    private ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }

    @Transactional
    public Article newArticle(Article a) throws ConstraintViolationException{
        logger.debug("Adding article " + a.getName() + " to de store");
        Article article = new Article(a.getCode(), a.getName(), a.getPrice(), a.getStock(), a.getDescription(), a.getAvailable());
        articleRepository.save(article);
        return article;
    }

    @Transactional(readOnly = true)
    public Article findByCode(String code){
        logger.debug("Searching article " + code);
        Article article = articleRepository.findByCode(code).orElse(null);
        return article;
    }

    @Transactional
    public Article updateArticle(Article a) throws ConstraintViolationException{
        logger.debug("Updating article " + a.getCode() + " - " + a.getName());
        Article article = articleRepository.findByCode(a.getCode()).orElse(null);
        if (article == null) {
            throw  new ArticleServiceException("There is no article with code " + a.getCode());
        }
        if (a.getName() != null) {
            article.setName(a.getName());
        }
        if (a.getPrice() != null) {
            article.setPrice(a.getPrice());
        }
        if (a.getStock() != null) {
            article.setStock(a.getStock());
        }
        if (a.getDescription() != null) {
            article.setDescription(a.getDescription());
        }
        if (a.getAvailable() != null) {
            article.setAvailable(a.getAvailable());
        }
        articleRepository.save(article);
        return article;
    }

    @Transactional
    public void deleteArticle(String code) {
        logger.debug("Deleting article " + code);
        Article article = articleRepository.findByCode(code).orElse(null);
        if (article == null) {
            throw  new ArticleServiceException("There is no article with code " + code);
        }
        articleRepository.delete(article);
    }
}
