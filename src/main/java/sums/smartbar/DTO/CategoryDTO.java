package sums.smartbar.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter @Getter
public class CategoryDTO {

    private Integer id;
    private String name;
    private Integer pubId;

    public CategoryDTO(Integer id, String name, Integer pubId) {
        this.id = id;
        this.name = name;
        this.pubId = pubId;
    }

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pubId=" + pubId +
                '}';
    }
}
