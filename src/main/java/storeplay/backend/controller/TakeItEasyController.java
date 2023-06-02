package storeplay.backend.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import storeplay.backend.client.HTTPClient;
import storeplay.backend.dto.PickupPointDTO;

@RestController
@CrossOrigin(origins={  "http://localhost:3000", "http://127.0.0.1:3000", "http://0.0.0.0:3000", 
                        "https://localhost:3000", "https://127.0.0.1:3000", "https://0.0.0.0:3000",
                        "http://localhost:5173", "http://127.0.0.1:5173", "http://0.0.0.0:5173", 
                        "https://localhost:5173", "https://127.0.0.1:5173", "https://0.0.0.0:5173"
                    })
@RequestMapping("/api/v1/pickuppoints/")
public class TakeItEasyController {

    @Autowired
    private HTTPClient httpClient = new HTTPClient();
    
    @GetMapping("")
    public ResponseEntity<List<PickupPointDTO>> getAllStores() throws ClientProtocolException, IOException {
        String response = httpClient.getAvailablePickupPoints();
        JSONArray pickupPoints_JSON  = new JSONArray(response);

        List<PickupPointDTO> pickupPointDTOs = new ArrayList<>();
        for (int i = 0; i < pickupPoints_JSON.length(); i++) {
            JSONObject pickupPoint_JSON = (JSONObject)pickupPoints_JSON.get(i);
            System.out.println(pickupPoint_JSON);
            PickupPointDTO pickupPointDTO = new PickupPointDTO( (String)pickupPoint_JSON.get("name"),
                                                                (String)pickupPoint_JSON.get("address"),
                                                                (String)pickupPoint_JSON.get("email"),
                                                                (String)pickupPoint_JSON.get("status")
            );
            pickupPointDTOs.add(pickupPointDTO);
        }
        return ResponseEntity.ok().body(pickupPointDTOs);
    }
}
