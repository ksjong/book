package bookshop.domain;

import bookshop.domain.*;
import bookshop.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class StockDecreased extends AbstractEvent {

    private Long id;
    private String bookName;
    private String bookimg;
    private Integer stock;

    public StockDecreased(BookManagement aggregate) {
        super(aggregate);
    }

    public StockDecreased() {
        super();
    }
}
//>>> DDD / Domain Event
