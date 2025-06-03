package com.anycomp.marketplace.service;

import com.anycomp.marketplace.dto.ItemDto;
import com.anycomp.marketplace.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ItemService {
    Page<ItemDto> findAll(Pageable pageable);
    ItemDto findById(Long id);
    List<ItemDto> getSellerItems(Long sellerId);
    ItemDto addSellerItem(Long sellerId, Item item);
    ItemDto update(Long id, Item item);
    void delete(Long id);
}
