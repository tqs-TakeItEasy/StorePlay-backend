package storeplay.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import storeplay.backend.model.Item;
import storeplay.backend.repository.ItemRepository;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

}
