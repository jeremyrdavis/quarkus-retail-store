package com.redhat.demos.quarkusretailstore.store;

import io.quarkus.arc.config.ConfigPrefix;
import io.smallrye.config.ConfigMapping;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.inject.Inject;
import javax.inject.Singleton;

@ConfigMapping(prefix = "store")
public interface Store {

    String storeId();

    String storeName();

    Address storeAddress();

    Address physicalAddress();

    Address mailingAddress();

    Address billingAddress();

    

}