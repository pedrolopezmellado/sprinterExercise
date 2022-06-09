package sprinter.controller;

import sprinter.controller.exception.ArticleNotFoundException;
import sprinter.model.Article;
import sprinter.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @PostMapping("/articles/new")
    @ResponseBody
    public String newArticle(@RequestBody Article article) {
        articleService.newArticle(article);
        return "Article successfully created";
    }

    @GetMapping("/articles/search")
    @ResponseBody
    public Article obtainArticle(@RequestBody Article article) {
        Article result = articleService.findByCode(article.getCode());
        if(result == null){
            throw new ArticleNotFoundException();
        }
        return result;
    }

    @DeleteMapping("/articles/delete")
    @ResponseBody
    public String deleteArticle(@RequestBody Article article){
        articleService.deleteArticle(article.getCode());
        return "Article successfully deleted";
    }

    @PutMapping("/articles/update")
    @ResponseBody
    public String updateArticle(@RequestBody Article article){
        articleService.updateArticle(article);
        return "Article successfully updated";
    }

}
