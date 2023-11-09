package bookshop.domain;

import bookshop.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class Ordered extends AbstractEvent {

    private Long id;
    private String userId;
    private String bookName;
    private Long bookId;
    private Integer qty;
    private String status;
    private Date orderDate;
    private String address;
}
