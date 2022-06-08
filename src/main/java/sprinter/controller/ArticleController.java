package sprinter.controller;

import sprinter.controller.exception.ArticleNotFoundException;
import sprinter.model.Article;
import sprinter.service.ArticleService;
import sprinter.service.ArticleServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class ArticleController {

    @Autowired
    ArticleService articleService;


    @PostMapping("/articles/new")
    @ResponseBody
    public String newArticle(@RequestBody Article article,
                             BindingResult result) {
        articleService.newArticle(article);
        return "Article successful created";
    }

    @GetMapping("/articles/search")
    @ResponseBody
    @ExceptionHandler(ArticleServiceException.class)
    public Article obtainArticle(@RequestBody Article article) {
        Article result = articleService.findByCode(article.getCode());
        if(result == null){
            throw new ArticleNotFoundException();
        }
        return result;
    }

}
