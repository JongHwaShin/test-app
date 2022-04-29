package com.Multi.testapp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter @Setter
public class Animal {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String animalname;

    @Column
    private String animaltype;

    @Column
    private Long age;


}
