package uz.pdp.ecommersapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.ecommersapp.entity.Cart;
import uz.pdp.ecommersapp.entity.User;
import uz.pdp.ecommersapp.payload.CartAdressSetReq;
import uz.pdp.ecommersapp.payload.CartProductReq;
import uz.pdp.ecommersapp.payload.Result;
import uz.pdp.ecommersapp.security.CurrentUser;
import uz.pdp.ecommersapp.service.CartService;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    CartService cartService;


    @GetMapping
    public ResponseEntity<Cart> getCart(@CurrentUser User user) {
        return cartService.getCart(user);
    }

    @PostMapping("/addproducts")
    public ResponseEntity<Result> addProducts(@RequestBody CartProductReq cartProductReq, @CurrentUser User user) {
        return cartService.addProducts(cartProductReq, user);
    }

    @PostMapping("/addadress")
    public ResponseEntity<Result> addAdress(@RequestBody CartAdressSetReq cartAdressSetReq, @CurrentUser User user){
        return cartService.addAdress(cartAdressSetReq, user);
    }
}
