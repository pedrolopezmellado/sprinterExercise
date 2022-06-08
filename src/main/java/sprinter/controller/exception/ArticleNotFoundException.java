package sprinter.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason="There is no article with that code")
public class ArticleNotFoundException extends RuntimeException{

}
