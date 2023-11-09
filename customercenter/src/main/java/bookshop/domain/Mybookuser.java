package bookshop.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "Mybookuser_table")
@Data
public class Mybookuser {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String userId;
    private Long orderId;
    private String bookName;
    private Integer qty;
    private Date orderDate;
    private String orderStatus;
    private String deliveryStatus;
    private Date deliveryDate;
}
