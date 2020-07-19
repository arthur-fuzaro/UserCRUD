package com.fuzaro.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "USER_CONTACT")
public class UserContactEntity {

    @Id
    @Column(name = "USER_ID")
    private String UserId;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "DETAILS")
    private String details;

}
