package storeplay.backend.controller;

import java.io.IOException;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import storeplay.backend.client.HTTPClient;
import storeplay.backend.dto.DeliveryDTO;
import storeplay.backend.dto.PackageDTO;
import storeplay.backend.exception.ResourceNotFoundException;
import storeplay.backend.model.Package;
import storeplay.backend.model.Store;
import storeplay.backend.service.ClientService;
import storeplay.backend.service.PackageService;
import storeplay.backend.service.StoreService;


@RestController
@CrossOrigin(origins={  "http://localhost:3000", "http://127.0.0.1:3000", "http://0.0.0.0:3000", 
                        "https://localhost:3000", "https://127.0.0.1:3000", "https://0.0.0.0:3000",
                        "http://localhost:5173", "http://127.0.0.1:5173", "http://0.0.0.0:5173", 
                        "https://localhost:5173", "https://127.0.0.1:5173", "https://0.0.0.0:5173"
                    })
@RequestMapping("/api/v1/packages/")
public class PackageController{

    @Autowired
    PackageService packageService;

    @Autowired
    ClientService clientService;

    @Autowired
    StoreService storeService;

    @Autowired
    private HTTPClient httpClient = new HTTPClient();

    @PostMapping("add/")
    public ResponseEntity<Package> addPackage(@RequestBody PackageDTO packageDTO) throws IOException, ResourceNotFoundException {

        Store store = storeService.getStoreById(packageDTO.getStoreId());

        Package newPackage = new Package(   packageDTO.getClientName(),
                                            packageDTO.getClientEmail(),
                                            packageDTO.getPickupPointId(),
                                            "AVAILABLE",
                                            store,
                                            packageDTO.getPackageItemsIds());

        newPackage = packageService.addPackage(newPackage);

        System.out.println(newPackage.getId());

        DeliveryDTO deliveryDTO = new DeliveryDTO(  packageDTO.getClientName(), 
                                                    packageDTO.getClientEmail(), 
                                                    newPackage.getId(), 
                                                    store.getId(), 
                                                    packageDTO.getPickupPointId());

        String response = httpClient.postDelivery(deliveryDTO);
        JSONObject packageDTO_JSON = new JSONObject(response);

        Long deliveryID = Long.valueOf(((Integer)packageDTO_JSON.get("deliveryId")).longValue());

        newPackage.setDeliveryId(deliveryID);
        packageService.updatePackage(newPackage);

        return ResponseEntity.ok().body(newPackage);
    }
}