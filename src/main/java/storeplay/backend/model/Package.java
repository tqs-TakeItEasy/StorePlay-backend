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

    @ManyToOne
    @JoinColumn(name = "client_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Client client;

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

    @OneToMany(mappedBy = "package_item", cascade = CascadeType.ALL)
    private List<Item> items;

    @Column(name = "delivery_id")
    private String delivery_id;
    @Column(name = "purchase_date")
    private String purchaseDate;

    @Column(name = "delivery_date")
    private String deliveryDate;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getDelivery_id() {
        return delivery_id;
    }

    public void setDelivery_id(String delivery_id) {
        this.delivery_id = delivery_id;
    }

    @Column(name = "pickup_date")
    private String pickupDate;

    public Package(List<Item> items) {
        this.items = items;
    }

    public Package() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(String pickupDate) {
        this.pickupDate = pickupDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Package aPackage = (Package) o;
        return id.equals(aPackage.id) && client.equals(aPackage.client) && pickupPoint.equals(aPackage.pickupPoint) && status == aPackage.status && store.equals(aPackage.store) && items.equals(aPackage.items) && delivery_id.equals(aPackage.delivery_id) && purchaseDate.equals(aPackage.purchaseDate) && deliveryDate.equals(aPackage.deliveryDate) && pickupDate.equals(aPackage.pickupDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, client, pickupPoint, status, store, items, delivery_id, purchaseDate, deliveryDate, pickupDate);
    }
}

