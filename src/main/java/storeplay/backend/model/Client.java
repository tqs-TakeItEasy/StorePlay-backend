package storeplay.backend.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "psw")
    private String psw;

    @Column(name = "birthdate")
    private String birthdate;

    public Client() {}

    
    public String getBirthdate() {
        return birthdate;
    }
    public String getEmail() {
        return email;
    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getPsw() {
        return psw;
    }
    
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPsw(String psw) {
        this.psw = psw;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id.equals(client.id) && name.equals(client.name) && email.equals(client.email) && psw.equals(client.psw) && birthdate.equals(client.birthdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, psw, birthdate);
    }
}
