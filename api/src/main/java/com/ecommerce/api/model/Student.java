package com.ecommerce.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Student {
    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String role;
    private String email;
    private String phoneNumber;
    private String password;
    private String isActive;
    private String lastUpdatedDate;
}
