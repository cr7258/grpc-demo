package org.javaboy.grpc.demo;

import io.grpc.stub.StreamObserver;

public class ProductInfoImpl extends ProductInfoGrpc.ProductInfoImplBase {
    @Override
    public void addProduct(Product request, StreamObserver<ProductId> responseObserver) {
        System.out.println("request.toString() = " + request.toString());
        responseObserver.onNext(ProductId.newBuilder().setValue(request.getId()).build());
        responseObserver.onCompleted();
    }

    @Override
    public void getProduct(ProductId request, StreamObserver<Product> responseObserver) {
        responseObserver.onNext(Product.newBuilder().setId(request.getValue()).setName("三国演义").build());
        responseObserver.onCompleted();
    }
}