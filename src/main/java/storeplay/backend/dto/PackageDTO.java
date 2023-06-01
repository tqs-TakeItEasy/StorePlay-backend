package storeplay.backend.dto;


import java.util.List;
import java.util.Map;

public class PackageDTO {
    //private Long clientId;

    private String clientName;

    private String clientEmail;
    private Long storeId;
    private Long PUPId;
    private List<Long> package_itemsIds;

    public PackageDTO(){}
    //public PackageDTO(Long clientId, Long storeId, Long PUPId, List<Long> package_itemsIds) {
    //    this.clientId = clientId;
    //    this.storeId = storeId;
    //    this.PUPId = PUPId;
    //    this.package_itemsIds = package_itemsIds;
    //}

    public PackageDTO(String clientName, String clientEmail, Long storeId, Long PUPId, List<Long> package_itemsIds) {
        this.clientName = clientName;
        this.clientEmail = clientEmail;
        this.storeId = storeId;
        this.PUPId = PUPId;
        this.package_itemsIds = package_itemsIds;
    }

    //public Long getClientId() {return clientId;}

    //public void setClientId(Long clientId) {this.clientId = clientId;}



    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getPUPId() {
        return PUPId;
    }

    public void setPUPId(Long PUPId) {
        this.PUPId = PUPId;
    }

    public List<Long> getPackage_itemsIds() {
        return package_itemsIds;
    }

    public void setPackage_itemsIds(List<Long> package_itemsIds) {
        this.package_itemsIds = package_itemsIds;
    }
}

