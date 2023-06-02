package storeplay.backend.model;

import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "package")
public class Package {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@ManyToOne
    //@JoinColumn(name = "client_id")
    //@OnDelete(action = OnDeleteAction.CASCADE)
    //private Client client;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "client_email")
    private String clientEmail;

    @JoinColumn(name = "pickup_point_id")
    private Long pickupPointId;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "store_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Store store;

    @Column(name = "deliveryid")
    private Long deliveryId;

    @Column(name = "itemslist")
    @ElementCollection
    private List<Long> items;


    public Package() {}
    public Package(String clientName, String clientEmail, Long pickupPointIdId, String status, Store store, List<Long> items) {
        this.clientName = clientName;
        this.clientEmail = clientEmail;
        this.pickupPointId = pickupPointIdId;
        this.status = status;
        this.store = store;
        this.items = items;
    }

    public String getClientEmail() {
        return clientEmail;
    }
    public String getClientName() {
        return clientName;
    }
    public Long getDeliveryId() {
        return deliveryId;
    }
    public Long getId() {
        return id;
    }
    public List<Long> getItems() {
        return items;
    }
    public Long getPickupPointId() {
        return pickupPointId;
    }
    public String getStatus() {
        return status;
    }
    public Store getStore() {
        return store;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setItems(List<Long> items) {
        this.items = items;
    }
    public void setPickupPointId(Long pickupPointId) {
        this.pickupPointId = pickupPointId;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setStore(Store store) {
        this.store = store;
    }
}

