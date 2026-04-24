package com.example.InvertoryService.grpc;
import com.example.InvertoryService.entity.Products;
import com.example.InvertoryService.repos.ProductsRepository;
import io.grpc.stub.StreamObserver;
import lombok.AllArgsConstructor;
import org.springframework.grpc.server.service.GrpcService;
import com.example.grpc.InventoryServiceGrpc;
import com.example.grpc.ProductsRequest;
import com.example.grpc.ProductsResponse;

@GrpcService
@AllArgsConstructor
public class InventoryServiceImpl extends InventoryServiceGrpc.InventoryServiceImplBase {

    private final ProductsRepository productsRepository;


    public void checkAvailability(ProductsRequest request, StreamObserver<ProductsResponse> responseObserver) {
        Long productId = request.getId();

        Products product = productsRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Товар не найден"));

        ProductsResponse response = ProductsResponse.newBuilder() //
                .setId(product.getId())
                .setName(product.getName())
                .setQuantity(product.getQuantity())
                .setPrice(product.getPrice().toString())
                .setSale(product.getSale().toString())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
