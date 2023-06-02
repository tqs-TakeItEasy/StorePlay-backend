package storeplay.backend.dto;

import java.util.List;

public class PackageDTO {
    private String clientName;
    private String clientEmail;
    private Long storeId;
    private Long pickupPointId;
    private List<Long> packageItemsIds;

    public PackageDTO(){}

    public String getClientEmail() {
        return clientEmail;
    }
    public String getClientName() {
        return clientName;
    }
    public List<Long> getPackageItemsIds() {
        return packageItemsIds;
    }
    public Long getPickupPointId() {
        return pickupPointId;
    }
    public Long getStoreId() {
        return storeId;
    }
    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
    public void setPackageItemsIds(List<Long> packageItemsIds) {
        this.packageItemsIds = packageItemsIds;
    }
    public void setPickupPointId(Long pickupPointId) {
        this.pickupPointId = pickupPointId;
    }
    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
}

