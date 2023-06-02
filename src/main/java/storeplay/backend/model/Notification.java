package storeplay.backend.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "store_email")
    private String store_email;

    @Column(name = "client_email")
    private String client_email;

    @Column(name = "message")
    private String message;

    public String getClient_email() {
        return client_email;
    }
    public Long getId() {
        return id;
    }
    public String getMessage() {
        return message;
    }
    public String getStore_email() {
        return store_email;
    }

    public void setClient_email(String client_email) {
        this.client_email = client_email;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public void setStore_email(String store_email) {
        this.store_email = store_email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notification that = (Notification) o;
        return id.equals(that.id) && store_email.equals(that.store_email) && client_email.equals(that.client_email) && message.equals(that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, store_email, client_email, message);
    }
}
