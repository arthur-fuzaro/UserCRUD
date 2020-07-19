package com.fuzaro.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "USER")
public class UserInformationEntity {

    @Id
    private String id;

    @Column(name = "NAME", updatable = false, nullable = false)
    private String name;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "BIRTH_DATE", nullable = false)
    private String birthDate;

    @Column(name = "ADDRESS")
    private String address;

    @JoinColumn(name = "CONTACT")
    private List<UserContactEntity> contact;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    @Column(name = "UPDATED_AT")
    private LocalDateTime updateAt;

}
