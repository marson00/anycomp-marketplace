package com.anycomp.marketplace.controller;

import com.anycomp.marketplace.dto.ItemDto;
import com.anycomp.marketplace.entity.Item;
import com.anycomp.marketplace.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/items")
    public Page<ItemDto> getAllItems(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortOrder) {
        Sort sort = sortOrder.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page, size, sort);

        return itemService.findAll(pageable);
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
