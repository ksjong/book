package bookshop.domain;

import bookshop.domain.*;
import bookshop.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class DeliveryStarted extends AbstractEvent {

    private Long id;
    private String userId;
    private Long orderId;
    private String bookName;
    private Long bookId;
    private Integer qty;
    private String status;
    private Date deliveryDate;

    public DeliveryStarted(DeliveryManagement aggregate) {
        super(aggregate);
    }

    public DeliveryStarted() {
        super();
    }
}
//>>> DDD / Domain Event
