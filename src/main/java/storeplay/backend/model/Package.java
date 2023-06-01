package storeplay.backend.model;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;
import java.util.Objects;

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


    // Retirar se Client for usado
    @Column(name = "client_name")
    private String client_name;

    // Retirar se Client for usado
    @Column(name = "client_email")
    private String client_email;

    @ManyToOne
    @JoinColumn(name = "pickup_point_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private PickupPoint pickupPoint;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "store_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Store store;

    @Column(name = "delivery_id")
    private Long delivery_id;

    @Column(name = "itemsList")
    @ElementCollection
    private List<Long> items;

    public List<Long> getItems() {
        return items;
    }

    public void setItems(List<Long> items) {
        this.items = items;
    }

    public Long getDelivery_id() {
        return delivery_id;
    }

    public void setDelivery_id(Long delivery_id) {
        this.delivery_id = delivery_id;
    }

    //public Package(Client client, PickupPoint pickupPoint, String status, Store store, List<Long> items) {
    //    this.client = client;
    //    this.pickupPoint = pickupPoint;
    //    this.status = status;
    //    this.store = store;
    //    this.items = items;
    //}

    public Package() {

    }

    // Retirar se Client for usado
    public Package(String client_name, String client_email, PickupPoint pickupPoint, String status, Store store, List<Long> items) {
        this.client_name = client_name;
        this.client_email = client_email;
        this.pickupPoint = pickupPoint;
        this.status = status;
        this.store = store;
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getClient_email() {
        return client_email;
    }

    public void setClient_email(String client_email) {
        this.client_email = client_email;
    }

    public PickupPoint getPickupPoint() {
        return pickupPoint;
    }

    public void setPickupPoint(PickupPoint pickupPoint) {
        this.pickupPoint = pickupPoint;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}

