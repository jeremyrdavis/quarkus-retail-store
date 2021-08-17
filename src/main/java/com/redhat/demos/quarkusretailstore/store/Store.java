package com.redhat.demos.quarkusretailstore.store;

import com.redhat.demos.quarkusretailstore.products.Address;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.inject.Singleton;

@Singleton
public class Store {

    @ConfigProperty(name = "storeId")
    String storeId;

    @ConfigProperty(name = "storeName")
    String storeName;

    Address storeAddress;

    Address physicalAddress;

    Address mailingAddress;

    Address billingAddress;

    

}