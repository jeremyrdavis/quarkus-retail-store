package com.redhat.demos.quarkusretailstore.inventory.infrastrcuture;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;

@Alternative @ApplicationScoped
public class MockInventoryService {
}
