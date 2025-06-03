package com.anycomp.marketplace.mapper;

import com.anycomp.marketplace.dto.ItemDto;
import com.anycomp.marketplace.entity.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {

    public ItemDto toResponse(Item item) {
        ItemDto response = new ItemDto();
        response.setId(item.getId());
        response.setName(item.getName());
        response.setDescription(item.getDescription());
        response.setPrice(item.getPrice());
        response.setQuantity(item.getQuantity());
        response.setSellerId(item.getSeller().getId());

        return response;
    }
}
