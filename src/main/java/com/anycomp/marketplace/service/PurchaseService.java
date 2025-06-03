package com.anycomp.marketplace.service;

import com.anycomp.marketplace.dto.PurchaseRequest;
import com.anycomp.marketplace.dto.PurchaseResponse;

public interface PurchaseService {
    PurchaseResponse createPurchase(PurchaseRequest request);
}
