package storeplay.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import storeplay.backend.model.Item;
import storeplay.backend.service.ItemService;


import java.util.List;

@RestController
@CrossOrigin(origins={"http://localhost:3000", "http://127.0.0.1:3000"})
@RequestMapping("/api/v1/items/")
public class ItemController{

    @Autowired
    ItemService itemService;

    @GetMapping("")
    public ResponseEntity<List<Item>> getAllStores() {
        List<Item> allItems = itemService.getAllItems();
        return ResponseEntity.ok().body(allItems);
    }
}
