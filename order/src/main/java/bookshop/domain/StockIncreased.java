package bookshop.domain;

import bookshop.domain.*;
import bookshop.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class StockIncreased extends AbstractEvent {

    private Long id;
    private String bookName;
    private String bookimg;
    private Integer stock;
}
