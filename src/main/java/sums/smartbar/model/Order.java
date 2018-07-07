package sums.smartbar.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Date timestamp;

    public Order(Date timestamp) {
        this.timestamp = timestamp;
    }
}
