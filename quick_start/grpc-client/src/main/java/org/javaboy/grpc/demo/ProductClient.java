package org.javaboy.grpc.demo;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ProductClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052)
                .usePlaintext()
                .build();
        ProductInfoGrpc.ProductInfoBlockingStub stub = ProductInfoGrpc.newBlockingStub(channel);
        Product p = Product.newBuilder().setId("1")
                .setPrice(399.0f)
                .setName("gRPC 项目")
                .setDescription("gRPC 入门案例")
                .build();
        ProductId productId = stub.addProduct(p);
        System.out.println("productId.getValue() = " + productId.getValue());
        Product product = stub.getProduct(ProductId.newBuilder().setValue("99999").build());
        System.out.println("product.toString() = " + product.toString());
    }
}