package com.spring.testproject.data.entity;

import com.spring.testproject.data.entity.listener.CustomListener;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "listener")
@EntityListeners(CustomListener.class)
public class ListenerEntity {
    @Id

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
}
