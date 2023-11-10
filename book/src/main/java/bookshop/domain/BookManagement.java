package bookshop.domain;

import bookshop.BookApplication;
import bookshop.domain.StockDecreased;
import bookshop.domain.StockIncreased;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "BookManagement_table")
@Data
//<<< DDD / Aggregate Root
public class BookManagement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String bookName;
    private String bookimg;
    private Integer stock;

    @PostUpdate
    public void onPostUpdate() {
        StockDecreased stockDecreased = new StockDecreased(this);
        stockDecreased.publishAfterCommit();

        StockIncreased stockIncreased = new StockIncreased(this);
        stockIncreased.publishAfterCommit();
    }

    public static BookManagementRepository repository() {
        BookManagementRepository bookManagementRepository = BookApplication.applicationContext.getBean(
            BookManagementRepository.class
        );
        return bookManagementRepository;
    }

    //<<< Clean Arch / Port Method
    public static void decreaseStock(DeliveryStarted deliveryStarted) {
        repository().findById(deliveryStarted.getBookId()).ifPresent(BookManagement->{
            BookManagement.setStock(BookManagement.getStock() - deliveryStarted.getQty());
            repository().save(BookManagement);
         });

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void increaseStock(DeliveryReturned deliveryReturned) {


    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void increaseStock(DeliveryCancelled deliveryCancelled) {
        repository().findById(deliveryCancelled.getBookId()).ifPresent(BookManagement->{
            BookManagement.setStock(BookManagement.getStock() + deliveryCancelled.getQty());
            repository().save(BookManagement);
         });

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
