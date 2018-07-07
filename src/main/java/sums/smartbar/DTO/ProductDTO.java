package sums.smartbar.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class ProductDTO {

    private Integer id;
    private String name;
    private Integer price;
    private Integer pubId;
    private Integer categoryId;

    public ProductDTO(Integer id, String name, Integer price, Integer pubId, Integer categoryId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.pubId = pubId;
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", pubId=" + pubId +
                ", categoryId=" + categoryId +
                '}';
    }
}
