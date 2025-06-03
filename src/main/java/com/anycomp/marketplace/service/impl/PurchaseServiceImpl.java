package com.anycomp.marketplace.service.impl;

import com.anycomp.marketplace.dto.PurchaseRequest;
import com.anycomp.marketplace.dto.PurchaseResponse;
import com.anycomp.marketplace.entity.Buyer;
import com.anycomp.marketplace.entity.Item;
import com.anycomp.marketplace.entity.Purchase;
import com.anycomp.marketplace.mapper.PurchaseMapper;
import com.anycomp.marketplace.repository.BuyerRepository;
import com.anycomp.marketplace.repository.ItemRepository;
import com.anycomp.marketplace.repository.PurchaseRepository;
import com.anycomp.marketplace.service.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PurchaseServiceImpl implements PurchaseService {

    private final PurchaseRepository purchaseRepository;
    private final BuyerRepository buyerRepository;
    private final ItemRepository itemRepository;
    private final PurchaseMapper purchaseMapper;

    public PurchaseResponse createPurchase(PurchaseRequest request) {
        Buyer buyer = buyerRepository.findById(request.getBuyerId())
                .orElseThrow(() -> new RuntimeException("Buyer ID " + request.getBuyerId() + " not found"));
        Item item = itemRepository.findById(request.getItemId())
                .orElseThrow(() -> new RuntimeException("Item ID " + request.getItemId() + " not found"));

        // Quantity Validation
        if (item.getQuantity() < request.getQuantity()) {
            throw new RuntimeException("Insufficient stock for item ID " + request.getItemId());
        }

        // Deduct quantity
        item.setQuantity(item.getQuantity() - request.getQuantity());
        itemRepository.save(item);

        Purchase purchase = new Purchase();
        purchase.setBuyer(buyer);
        purchase.setItem(item);
        purchase.setQuantity(request.getQuantity());

        purchaseRepository.save(purchase);

        return purchaseMapper.toResponse(purchase);
    }
}
