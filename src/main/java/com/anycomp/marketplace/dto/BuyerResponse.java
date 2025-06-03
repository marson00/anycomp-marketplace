package com.anycomp.marketplace.dto;

import lombok.Data;

import java.util.List;

@Data
public class BuyerResponse {
    private Long id;
    private String name;
    private String email;
    private List<PurchaseResponse> purchases;
}
