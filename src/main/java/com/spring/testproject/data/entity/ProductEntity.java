package com.spring.testproject.data.entity;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString
@Table(name = "product")
public class ProductEntity extends BaseEntity { // BaseEntity 에 있는 컬럼을 상속 받아서 사용할 수 있다.
    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    @GeneratedValue(strategy = GenerationType.AUTO)
    String productId;
    String productName;
    Integer productPrice;
    Integer productStock;
}
