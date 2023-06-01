package storeplay.backend.controller;

import java.io.IOException;


import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import storeplay.backend.dto.DeliveryDTO;
import storeplay.backend.dto.PackageDTO;
import storeplay.backend.exception.ResourceNotFoundException;
import storeplay.backend.model.Client;
import storeplay.backend.model.Package;
import storeplay.backend.model.PickupPoint;
import storeplay.backend.model.Store;
import storeplay.backend.service.*;


@RestController
@CrossOrigin(origins={"http://localhost:3000", "http://127.0.0.1:3000"})
@RequestMapping("/api/v1/packages/")
public class PackageController{

    @Autowired
    PackageService packageService;

    @Autowired
    ClientService clientService;

    @Autowired
    StoreService storeService;

    @Autowired
    PickupPointService pickupPointService;

    @Autowired
    private HTTPClient httpClient = new HTTPClient();

    private CloseableHttpClient client = HttpClients.createDefault();

    @PostMapping("add/")
    public ResponseEntity<Package> addPackage(@RequestBody PackageDTO package_info) throws IOException, ResourceNotFoundException {
        // Chamar Client Service para ter name e email
        //Client client = clientService.getStoreById(package_info.getClientId());


        // Chamar Store Service para ter StoreId
        Store store = storeService.getStoreById(package_info.getStoreId());
        // Chamar PickUp Service para ter PickUp Controller
        PickupPoint pickupPoint = pickupPointService.getPUPById(package_info.getPUPId());
        //Criar Package
        Package newPackage = new Package(package_info.getClientName(), package_info.getClientEmail(), pickupPoint, "AVAILABLE", store, package_info.getPackage_itemsIds());
        newPackage = packageService.addPackage(newPackage);

        // criar delivery DTO
        //DeliveryDTO deliveryDTO = new DeliveryDTO(client.getName(), package_info.getEmail(), newPackage.getId() , store.getId(), pickupPoint.getId());
        DeliveryDTO deliveryDTO = new DeliveryDTO(package_info.getClientName(), package_info.getClientEmail(), newPackage.getId() , store.getId(), pickupPoint.getId());

        // Fazer post para criar uma delivery com o delivery dto
        // vai retornar a deliveryId
        String packageDTO = httpClient.postDeliveryDTOGetPackageDTO(deliveryDTO);
        JSONObject packageDTO_json = new JSONObject(packageDTO);

        Long deliveryID = packageDTO_json.getLong("deliveryID");
        newPackage.setDelivery_id(deliveryID);
        // vai ter uma deliveryID, para saber que o package associa-se à delivery,
        // Se quiser algo sobre uma delivery uso o delivery id do package
        newPackage = packageService.updateDeliveryId(newPackage.getId(), deliveryID);

        return ResponseEntity.ok().body(newPackage);
    }

    //@PutMapping("{packageID}/")
    //public  ResponseEntity<Package> recieveDeliveryID(@PathVariable(value="packageID") Long packageID, @RequestBody PackageDTO packageDTO){
    //    Package updatePackage = packageService.updatePackage(packageID, packageDTO);
    //}

}
