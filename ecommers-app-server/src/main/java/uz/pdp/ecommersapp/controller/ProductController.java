package uz.pdp.ecommersapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.ecommersapp.entity.Product;
import uz.pdp.ecommersapp.payload.ProductCategoryReq;
import uz.pdp.ecommersapp.payload.ProductReq;
import uz.pdp.ecommersapp.payload.ProductResponse;
import uz.pdp.ecommersapp.payload.Result;
import uz.pdp.ecommersapp.repository.ProductRepository;
import uz.pdp.ecommersapp.service.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductService productService;

    @PostMapping("/save")
    public ResponseEntity<Result> addProduct(@RequestBody ProductReq productReq) {
        return productService.addProduct(productReq);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Product> editProduct(@RequestBody ProductReq productReq, @PathVariable Integer id) {
        return productService.editProduct(id, productReq);
    }

    @PostMapping
    public ResponseEntity<List<ProductResponse>> takeProductByCategory(@RequestBody ProductCategoryReq productCategoryReq) {
        return productService.takeProductByCategory(productCategoryReq);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Result> deleteProduct(@PathVariable Integer id){
       return productService.deleteProduct(id);
    }

    @GetMapping("/top")
    public ResponseEntity<List<ProductResponse>> takeProductTop10() {
        return productService.takeProductTop10();
    }

    @GetMapping("/new")
    public ResponseEntity<List<ProductResponse>> takeProductNews() {
        return productService.takeProductNews();
    }

    @GetMapping("/take/{id}")
    public ResponseEntity<Product> takeProductById(@PathVariable Integer id) {
        Optional<Product> optional = productRepository.findById(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        } else
            return ResponseEntity.status(500).build();
    }

}
