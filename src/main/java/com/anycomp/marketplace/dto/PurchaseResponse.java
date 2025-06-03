package com.anycomp.marketplace.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class PurchaseResponse {
    private Long buyerId;
    private Long itemId;
    private int quantity;
    private Timestamp purchaseDate;
}
