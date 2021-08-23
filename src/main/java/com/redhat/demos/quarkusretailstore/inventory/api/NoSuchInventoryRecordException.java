package com.redhat.demos.quarkusretailstore.inventory.api;

public class NoSuchInventoryRecordException extends Throwable {

    String skuId;

    public NoSuchInventoryRecordException(final String skuId) {
        this.skuId = skuId;
    }

    @Override
    public String getMessage() {
        return new StringBuilder("No inventory record with the id ").append(skuId).append(" found.").toString();
    }
}
