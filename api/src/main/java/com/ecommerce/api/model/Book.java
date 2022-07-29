package com.ecommerce.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Book {
    private int isbn;
    private String bookName;
    private String author;
    private int originalStock;
    private int inStock;
    private String lastUpdatedDate;
    private int temporaryStock;

    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", originalStock=" + originalStock +
                ", inStock=" + inStock +
                ", lastUpdatedDate='" + lastUpdatedDate + '\'' +
                ", temporaryStock=" + temporaryStock +
                '}';
    }
}
