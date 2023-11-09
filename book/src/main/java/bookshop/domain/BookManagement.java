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
        //implement business logic here:

        /** Example 1:  new item 
        BookManagement bookManagement = new BookManagement();
        repository().save(bookManagement);

        StockDecreased stockDecreased = new StockDecreased(bookManagement);
        stockDecreased.publishAfterCommit();
        StockDecreased stockDecreased = new StockDecreased(bookManagement);
        stockDecreased.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryStarted.get???()).ifPresent(bookManagement->{
            
            bookManagement // do something
            repository().save(bookManagement);

            StockDecreased stockDecreased = new StockDecreased(bookManagement);
            stockDecreased.publishAfterCommit();
            StockDecreased stockDecreased = new StockDecreased(bookManagement);
            stockDecreased.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void increaseStock(DeliveryReturned deliveryReturned) {
        //implement business logic here:

        /** Example 1:  new item 
        BookManagement bookManagement = new BookManagement();
        repository().save(bookManagement);

        StockIncreased stockIncreased = new StockIncreased(bookManagement);
        stockIncreased.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryReturned.get???()).ifPresent(bookManagement->{
            
            bookManagement // do something
            repository().save(bookManagement);

            StockIncreased stockIncreased = new StockIncreased(bookManagement);
            stockIncreased.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void increaseStock(DeliveryCancelled deliveryCancelled) {
        //implement business logic here:

        /** Example 1:  new item 
        BookManagement bookManagement = new BookManagement();
        repository().save(bookManagement);

        StockIncreased stockIncreased = new StockIncreased(bookManagement);
        stockIncreased.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryCancelled.get???()).ifPresent(bookManagement->{
            
            bookManagement // do something
            repository().save(bookManagement);

            StockIncreased stockIncreased = new StockIncreased(bookManagement);
            stockIncreased.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
