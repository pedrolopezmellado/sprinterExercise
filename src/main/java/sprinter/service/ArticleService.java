package sprinter.service;

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

    public Article newArticle(Article a){
        logger.debug("Adding article " + a.getName() + " to de store");
        Article article = new Article(a.getCode(), a.getName(), a.getPrice(), a.getStock(), a.getDescription(), a.getAvailable());
        articleRepository.save(article);
        return article;
    }

    @Transactional(readOnly = true)
    public Article findByCode(String code){
        logger.debug("Searching article " + code);
        Article article = articleRepository.findByCode(code);
        return article;
    }

    @Transactional
    public Article updateArticle(Long idArticle, String code, String name, Double price, Integer stock, String description, Boolean available){
        logger.debug("Updating article " + idArticle + " - " + name);
        Article article = articleRepository.findById(idArticle).orElse(null);
        if (article == null) {
            throw  new ArticleServiceException("There is no article with id " + idArticle);
        }
        article.setCode(code);
        article.setName(name);
        article.setPrice(price);
        article.setStock(stock);
        article.setDescription(description);
        article.setAvailable(available);
        articleRepository.save(article);
        return article;
    }

    @Transactional
    public void deleteArticle(Long idArticle) {
        logger.debug("Deleting article " + idArticle);
        Article article = articleRepository.findById(idArticle).orElse(null);
        if (article == null) {
            throw  new ArticleServiceException("There is no article with id " + idArticle);
        }
        articleRepository.delete(article);
    }
}
