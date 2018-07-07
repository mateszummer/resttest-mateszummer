package sums.smartbar.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;



@Entity
@NoArgsConstructor
@Getter @Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Integer price;
    private Integer pubId;
    private Integer categoryId;

    public Product(String name, Integer price, Integer pubId, Integer categoryId) {
        this.name = name;
        this.price = price;
        this.pubId = pubId;
        this.categoryId = categoryId;
    }
}
