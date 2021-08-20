package com.redhat.demos.quarkusretailstore.products;

public class NoSuchProductException extends Exception {

    String skuId;

    public NoSuchProductException(final String skuId) {
        this.skuId = skuId;
    }

    @Override
    public String getMessage() {
        return new StringBuilder("No product with the id ").append(skuId).append(" found.").toString();
    }
}
