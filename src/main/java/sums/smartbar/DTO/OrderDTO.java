package sums.smartbar.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class OrderDTO {

    private Integer id;
    private Integer orderId;
    private Date timestamp;

}
