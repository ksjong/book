package bookshop.domain;

import bookshop.DeliveryApplication;
import bookshop.domain.DeliveryCancelled;
import bookshop.domain.DeliveryCompleted;
import bookshop.domain.DeliveryReturned;
import bookshop.domain.DeliveryStarted;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "DeliveryManagement_table")
@Data
//<<< DDD / Aggregate Root
public class DeliveryManagement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userId;
    private Long orderId;
    private String bookName;
    private Long bookId;
    private Integer qty;
    private String status;
    private Date deliveryDate;

    @PostPersist
    public void onPostPersist() {
        DeliveryStarted deliveryStarted = new DeliveryStarted(this);
        deliveryStarted.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        DeliveryCancelled deliveryCancelled = new DeliveryCancelled(this);
        deliveryCancelled.publishAfterCommit();
    }

    @PreUpdate
    public void onPreUpdate() {
        DeliveryCompleted deliveryCompleted = new DeliveryCompleted(this);
        deliveryCompleted.publishAfterCommit();

        DeliveryReturned deliveryReturned = new DeliveryReturned(this);
        deliveryReturned.publishAfterCommit();
    }

    public static DeliveryManagementRepository repository() {
        DeliveryManagementRepository deliveryManagementRepository = DeliveryApplication.applicationContext.getBean(
            DeliveryManagementRepository.class
        );
        return deliveryManagementRepository;
    }

    //<<< Clean Arch / Port Method
    public static void startDelivery(Ordered ordered) {
        DeliveryManagement deliveryManagement = new DeliveryManagement();
        deliveryManagement.setBookName(ordered.getBookName());
        deliveryManagement.setBookId(ordered.getBookId());
        deliveryManagement.setQty(ordered.getQty());
        deliveryManagement.setStatus("DeliveryStarted");
        
        DeliveryStarted deliveryStarted = new DeliveryStarted(deliveryManagement);
        deliveryStarted.publishAfterCommit();

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void cancelDelivery(OrderCancelled orderCancelled) {

        DeliveryManagement deliveryManagement = new DeliveryManagement();
        deliveryManagement.setQty(orderCancelled.getQty());
        deliveryManagement.setBookName(orderCancelled.getBookName());
        deliveryManagement.setBookId(orderCancelled.getBookId());
        deliveryManagement.setQty(orderCancelled.getQty());
        deliveryManagement.setStatus("DeliveryCancelled");
        // repository().save(deliveryManagement);

        DeliveryCancelled deliveryCancelled = new DeliveryCancelled(deliveryManagement);
        deliveryCancelled.publishAfterCommit();
            


        //implement business logic here:

        /** Example 1:  new item 
        DeliveryManagement deliveryManagement = new DeliveryManagement();
        repository().save(deliveryManagement);

        DeliveryCancelled deliveryCancelled = new DeliveryCancelled(deliveryManagement);
        deliveryCancelled.publishAfterCommit();
        DeliveryReturned deliveryReturned = new DeliveryReturned(deliveryManagement);
        deliveryReturned.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderCancelled.get???()).ifPresent(deliveryManagement->{
            
            deliveryManagement // do something
            repository().save(deliveryManagement);

            DeliveryCancelled deliveryCancelled = new DeliveryCancelled(deliveryManagement);
            deliveryCancelled.publishAfterCommit();
            DeliveryReturned deliveryReturned = new DeliveryReturned(deliveryManagement);
            deliveryReturned.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
