package bookshop.domain;

import bookshop.domain.*;
import bookshop.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class DeliveryCancelled extends AbstractEvent {

    private Long id;
    private String userId;
    private Long orderId;
    private String bookName;
    private Long bookId;
    private Integer qty;
    private String status;
    private Date deliveryDate;
}
