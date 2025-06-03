package com.anycomp.marketplace.controller;

import com.anycomp.marketplace.dto.PurchaseRequest;
import com.anycomp.marketplace.entity.Purchase;
import com.anycomp.marketplace.service.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/purchase")
@RequiredArgsConstructor
public class PurchaseController {

    private final PurchaseService purchaseService;

    @PostMapping
    public void purchase(@RequestBody PurchaseRequest request) {
        purchaseService.createPurchase(request);
    }
}
