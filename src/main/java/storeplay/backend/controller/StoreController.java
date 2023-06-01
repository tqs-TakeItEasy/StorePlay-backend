package storeplay.backend.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import storeplay.backend.model.Store;
import storeplay.backend.service.StoreService;


@RestController
@CrossOrigin(origins={"http://localhost:3000", "http://127.0.0.1:3000"})
@RequestMapping("/api/v1/stores/")
public class StoreController{

    @Autowired
    StoreService storeService;

    @GetMapping("")
    public ResponseEntity<List<Store>> getAllStores() {
        List<Store> allStores = storeService.getAllStores();
        return ResponseEntity.ok().body(allStores);
    }
}

