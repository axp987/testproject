package com.spring.testproject.data.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ProductDto {
    private String productId;
    private String productName;
    private int productPrice;
    private int productStock;

//    public ProductEntity toEntity() {
//    }
}
