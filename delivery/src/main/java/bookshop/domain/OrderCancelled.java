package bookshop.domain;

import bookshop.domain.*;
import bookshop.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderCancelled extends AbstractEvent {

    private Long id;
    private String userId;
    private String bookName;
    private Long bookId;
    private Integer qty;
    private String status;
    private Date orderDate;
    private String address;
}
