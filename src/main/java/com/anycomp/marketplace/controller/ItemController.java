package com.anycomp.marketplace.controller;

import com.anycomp.marketplace.dto.ItemDto;
import com.anycomp.marketplace.entity.Item;
import com.anycomp.marketplace.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/items")
    public List<ItemDto> getAllItems() {
        return itemService.findAll();
    }

    @GetMapping("/items/{id}")
    public ItemDto getItem(@PathVariable Long id) {
        return itemService.findById(id);
    }

    @GetMapping("/sellers/{sellerId}/items")
    public List<ItemDto> getSellerItems(@PathVariable Long sellerId) {
        return itemService.getSellerItems(sellerId);
    }

    @PostMapping("/sellers/{sellerId}/items")
    public ItemDto addSellerItems(@PathVariable Long sellerId, @RequestBody Item item) {
        return itemService.addSellerItem(sellerId, item);
    }

    @PutMapping("/items/{id}")
    public ItemDto updateItem(@PathVariable Long id, @RequestBody Item item) {
        return itemService.update(id, item);
    }

    @DeleteMapping("/items/{id}")
    public void deleteItem(@PathVariable Long id) {
        itemService.delete(id);
    }

}
