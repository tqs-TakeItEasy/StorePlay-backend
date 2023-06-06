package storeplay.backend.dto;

public class PickupPointDTO {
    private Long id;
    private String name;
    private String address;
    private String email;
    private String status;

    public PickupPointDTO() {}
    public PickupPointDTO(Long id, String name, String address, String email, String status) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.status = status;
    }

    public Long getId() {
        return id;
    }
    public String getAddress() {
        return address;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getStatus() {
        return status;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}