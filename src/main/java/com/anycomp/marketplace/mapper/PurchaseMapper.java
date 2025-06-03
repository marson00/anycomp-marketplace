package com.anycomp.marketplace.mapper;

import com.anycomp.marketplace.dto.PurchaseResponse;
import com.anycomp.marketplace.entity.Purchase;
import org.springframework.stereotype.Component;

@Component
public class PurchaseMapper {

    public PurchaseResponse toResponse(Purchase purchase) {
        PurchaseResponse response = new PurchaseResponse();
        response.setBuyerId(purchase.getBuyer().getId());
        response.setItemId(purchase.getItem().getId());
        response.setQuantity(purchase.getQuantity());
        response.setPurchaseDate(purchase.getPurchaseDate());

        return response;
    }
}
