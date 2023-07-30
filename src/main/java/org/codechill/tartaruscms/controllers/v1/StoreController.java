package org.codechill.tartaruscms.controllers.v1;

import org.codechill.tartaruscms.entities.Store;
import org.codechill.tartaruscms.services.IStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/store")
public class StoreController {
    private final IStoreService storeService;

    @Autowired
    public StoreController(IStoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("")
    public List<Store> findAll() {
        return storeService.findAll();
    }

    @GetMapping("/{id}")
    public Store findById(@PathVariable Long id) {
        return storeService.findById(id);
    }

    @PostMapping("")
    public Store create(@RequestBody Store store) {
        return storeService.create(store);
    }

    @PatchMapping("/{id}")
    public Store update(@PathVariable Long id, @RequestBody Store store) {
        return storeService.update(store, id);
    }
}
