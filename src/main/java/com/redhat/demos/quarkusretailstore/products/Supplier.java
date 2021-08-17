package com.redhat.demos.quarkusretailstore.products;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Supplier extends PanacheEntity {

    String name;

    @OneToOne
    Address shippingAddress;

    @OneToOne
    Address billingAddress;

    @OneToOne
    Address mailingAddress;

}
