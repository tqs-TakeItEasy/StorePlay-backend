package storeplay.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import storeplay.backend.model.Item;
import storeplay.backend.model.Store;
import storeplay.backend.repository.ItemRepository;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

}
