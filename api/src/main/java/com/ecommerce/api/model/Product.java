package com.ecommerce.api.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String slug;
    private String image;
    private String brand;
    private String category;
    private String description;
    private int price;
    private int countInStock;
    private int rating;
    private int numReviews;
    private String timestamps;

}
