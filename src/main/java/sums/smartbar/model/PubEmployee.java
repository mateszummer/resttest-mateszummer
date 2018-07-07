package sums.smartbar.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class PubEmployee {

    private Integer pubId;
    private Integer employeeId;

}
