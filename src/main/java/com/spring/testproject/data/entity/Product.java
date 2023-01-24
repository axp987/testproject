package com.spring.testproject.data.entity;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.*;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@ToString
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseEntity {
    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    @GeneratedValue(strategy = GenerationType.AUTO)
    String id;
    String name;
    Integer price;
    Integer Stock;


}
