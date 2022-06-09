package sprinter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import sprinter.model.Article;
import sprinter.service.ArticleService;


import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class ArticleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ArticleService articleService;

    @Test
    @Transactional
    public void createController() throws Exception {

        JSONObject json = new JSONObject();
        json.put("code", "1234");
        json.put("name", "Ejemplo");
        json.put("price", 1.2);
        json.put("stock", 100);
        json.put("description", "Description");
        json.put("available", 1);

        this.mockMvc.perform(post("/articles/new")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(String.valueOf(json)))
                        .andExpect(content().string(containsString("Article successfully created")));
    }

    @Test
    public void modifyController() throws Exception {

        JSONObject json = new JSONObject();
        json.put("code", "123");
        json.put("name", "Ejemplo");

        this.mockMvc.perform(put("/articles/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(String.valueOf(json)))
                .andExpect(content().string(containsString("Article successfully updated")));
    }

    @Test
    public void deleteController() throws Exception {

        JSONObject json = new JSONObject();
        json.put("code", "123");

        this.mockMvc.perform(delete("/articles/delete")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(String.valueOf(json)))
                .andExpect(content().string(containsString("Article successfully deleted")));
    }

    @Test
    public void getController() throws Exception {

        JSONObject json = new JSONObject();
        json.put("code", "123");
        Article a = new Article("456", "Example", 12.99, 100, "Example description", true);
        ObjectMapper mapper = new ObjectMapper();

        String jsonResult = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(a);

        when(articleService.findByCode(any())).thenReturn(a);
        this.mockMvc.perform(get("/articles/search")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(String.valueOf(json)))
                .andExpect(content().json(jsonResult));
    }

}
