package storeplay.backend.model;


import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Arrays;
import java.util.Objects;


@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private String price;

    @Column(name = "image")
    private String profilePicture;

    @ManyToOne
    @JoinColumn(name = "store_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Store store;

    @ManyToOne
    @JoinColumn(name = "package_id")
    private Package package_item;

    public Item(Long id, String name, String price, String profilePicture, Package package_item) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.profilePicture = profilePicture;
        this.package_item = package_item;
    }

    public Item() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public Store getStore() {
        return store;
    }

    public Package getPackage_item() {
        return package_item;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public void setPackage_item(Package package_item) {
        this.package_item = package_item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id.equals(item.id) && name.equals(item.name) && price.equals(item.price) && profilePicture.equals(item.profilePicture) && store.equals(item.store) && package_item.equals(item.package_item);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, name, price,profilePicture ,store, package_item);

        return result;
    }
}
