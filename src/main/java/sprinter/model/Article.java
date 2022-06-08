package sprinter.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "articles")
public class Article implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String code;
    @NotNull
    private String name;
    private Double price;
    private Integer stock;
    private String description;
    private Boolean available;


    private Article() {}

    public Article(String code, String name, Double price, Integer stock, String description, Boolean available){
        this.code = code;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.description = description;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(id, article.id) && Objects.equals(code, article.code) && Objects.equals(name, article.name) && Objects.equals(price, article.price) && Objects.equals(stock, article.stock) && Objects.equals(description, article.description) && Objects.equals(available, article.available);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name, price, stock, description, available);
    }
}
