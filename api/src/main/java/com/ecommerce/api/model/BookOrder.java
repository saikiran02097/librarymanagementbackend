package com.ecommerce.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class BookOrder {
    private int isbn;
    private int studentId;
    private String issuedBy;
    private String issueDate;
    private int inStock;
    private int penalty;
    private String status;
    private String lastUpdatedDate;
}
