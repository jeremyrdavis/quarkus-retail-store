package com.redhat.demos.quarkusretailstore.products;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class ProductMaster extends PanacheEntity {

    String skuId;

    String description;

}
