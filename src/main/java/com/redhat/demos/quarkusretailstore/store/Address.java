package com.redhat.demos.quarkusretailstore.store;

import io.smallrye.config.ConfigMapping;

public interface Address {

    String street();

    String city();

    String state();

    String zip();
}
