package uz.pdp.ecommersapp.service;

import org.springframework.http.ResponseEntity;
import uz.pdp.ecommersapp.entity.Product;
import uz.pdp.ecommersapp.payload.ProductCategoryReq;
import uz.pdp.ecommersapp.payload.ProductReq;
import uz.pdp.ecommersapp.payload.ProductResponse;
import uz.pdp.ecommersapp.payload.Result;

import java.util.List;

public interface ProductService {
    ResponseEntity<Result> addProduct(ProductReq productReq);
    ResponseEntity<Product> editProduct(Integer id, ProductReq productReq);
    ResponseEntity<Result>deleteProduct(Integer id);
    ResponseEntity<List<ProductResponse>> takeProductByCategory(ProductCategoryReq productCategoryReq);
    ResponseEntity<List<ProductResponse>> takeProductTop10();
    ResponseEntity<List<ProductResponse>> takeProductNews();

}
