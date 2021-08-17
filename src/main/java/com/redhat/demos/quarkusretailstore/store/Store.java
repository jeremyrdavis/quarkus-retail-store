package com.redhat.demos.quarkusretailstore.store;

import com.redhat.demos.quarkusretailstore.products.Address;

import javax.inject.Singleton;

@Singleton
public class Store {

    String storeId;

    String storeName;

    Address storeAddress;

    Address physicalAddress;

    Address mailingAddress;

    Address billingAddress;

    

}