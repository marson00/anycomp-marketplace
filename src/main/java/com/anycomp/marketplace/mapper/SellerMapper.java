package com.anycomp.marketplace.mapper;

import com.anycomp.marketplace.dto.*;
import com.anycomp.marketplace.entity.Buyer;
import com.anycomp.marketplace.entity.Seller;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SellerMapper {

    private final ItemMapper itemMapper;

    public SellerResponse toResponse(Seller seller) {
        SellerResponse response = new SellerResponse();
        response.setId(seller.getId());
        response.setName(seller.getName());
        response.setEmail(seller.getEmail());

        if(seller.getItems() != null) {
            List<ItemDto> items = seller.getItems()
                    .stream()
                    .map(itemMapper::toResponse)
                    .collect(Collectors.toList());
            response.setItems(items);
        }

        return response;
    }

    public Seller toEntity(SellerRequest request) {
        Seller seller = new Seller();
        seller.setName(request.getName());
        seller.setEmail(request.getEmail());
        return seller;
    }
}
