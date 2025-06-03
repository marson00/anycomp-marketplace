package com.anycomp.marketplace.service;

import com.anycomp.marketplace.dto.PurchaseRequest;

public interface PurchaseService {
    void createPurchase(PurchaseRequest request);
}
