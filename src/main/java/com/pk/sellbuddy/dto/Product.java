package com.pk.sellbuddy.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Product {

    @NotNull(message = "Invalid Product Id: Null Id")
    @NotBlank(message = "Invalid Product Id: Empty Product Id")
    private String productId;

    @NotNull(message = "Invalid Name: Null Name")
    @NotBlank(message = "Invalid Name: Empty Name")
    @Size(min = 2,max = 30,message = "Name should be between 2 to 30 Character")
    private String name;
    private double cost;
}
