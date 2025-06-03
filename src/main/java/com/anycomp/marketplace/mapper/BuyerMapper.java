package com.anycomp.marketplace.mapper;

import com.anycomp.marketplace.dto.BuyerRequest;
import com.anycomp.marketplace.dto.BuyerResponse;
import com.anycomp.marketplace.dto.PurchaseResponse;
import com.anycomp.marketplace.entity.Buyer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BuyerMapper {

    private final PurchaseMapper purchaseMapper;

    public BuyerResponse toResponse(Buyer buyer) {
        BuyerResponse response = new BuyerResponse();
        response.setId(buyer.getId());
        response.setName(buyer.getName());
        response.setEmail(buyer.getEmail());

        if(buyer.getPurchasedItems() != null) {
            List<PurchaseResponse> purchases = buyer.getPurchasedItems()
                    .stream()
                    .map(purchaseMapper::toResponse)
                    .collect(Collectors.toList());
            response.setPurchases(purchases);
        }

        return response;
    }

    public Buyer toEntity(BuyerRequest request) {
        Buyer buyer = new Buyer();
        buyer.setName(request.getName());
        buyer.setEmail(request.getEmail());
        return buyer;
    }
}
