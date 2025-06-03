package com.anycomp.marketplace.service.impl;

import com.anycomp.marketplace.dto.ItemDto;
import com.anycomp.marketplace.entity.Item;
import com.anycomp.marketplace.entity.Seller;
import com.anycomp.marketplace.mapper.ItemMapper;
import com.anycomp.marketplace.repository.ItemRepository;
import com.anycomp.marketplace.repository.SellerRepository;
import com.anycomp.marketplace.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final SellerRepository sellerRepository;
    private final ItemMapper itemMapper;

    @Override
    public Page<ItemDto> findAll(Pageable pageable) {
//        return itemRepository.findAll()
//                .stream()
//                .map(itemMapper::toResponse)
//                .toList();

        return itemRepository.findAll(pageable)
                .map(itemMapper::toResponse);
    }

    @Override
    public ItemDto findById(Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item ID " + id + " Not Found"));

        return itemMapper.toResponse(item);
    }

    @Override
    public List<ItemDto> getSellerItems(Long sellerId) {
        return itemRepository.findAll()
                .stream()
                .filter(item -> item.getSeller().getId().equals(sellerId))
                .map(itemMapper::toResponse)
                .toList();
    }

    @Override
    public ItemDto addSellerItem(Long sellerId, Item item) {
        Seller seller = sellerRepository.findById(sellerId)
                .orElseThrow(() -> new RuntimeException("Seller ID " + sellerId + " Not Found"));

        item.setSeller(seller);
        Item savedItem = itemRepository.save(item);

        return itemMapper.toResponse(savedItem);
    }

    @Override
    public ItemDto update(Long id, Item item) {
        Item existingItem = itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item ID " + id + " Not Found"));

        existingItem.setName(item.getName());
        existingItem.setDescription(item.getDescription());
        existingItem.setPrice(item.getPrice());
        existingItem.setQuantity(item.getQuantity());

        if (item.getSeller() != null && (existingItem.getSeller() == null
                || !existingItem.getSeller().getId().equals(item.getSeller().getId()))) {

            Long newSellerId = item.getSeller().getId();
            Seller newSeller = sellerRepository.findById(newSellerId)
                    .orElseThrow(() -> new RuntimeException("Seller ID " + newSellerId + " not found"));
            existingItem.setSeller(newSeller);
        }

        Item updatedItem = itemRepository.save(existingItem);
        return itemMapper.toResponse(updatedItem);
    }

    @Override
    public void delete(Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item ID " + id + " Not Found"));

        itemRepository.deleteById(id);
    }
}
