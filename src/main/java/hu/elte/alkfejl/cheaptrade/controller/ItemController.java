package hu.elte.alkfejl.cheaptrade.controller;


import hu.elte.alkfejl.cheaptrade.domain.item.Item;
import hu.elte.alkfejl.cheaptrade.domain.item.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("items")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("")
    public List<Item> findAllItem() {
        return itemService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Item> findById(@PathVariable Long id) {
        return itemService.findById(id);
    }


}
