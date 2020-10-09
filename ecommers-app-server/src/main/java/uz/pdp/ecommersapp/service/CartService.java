package uz.pdp.ecommersapp.service;

import org.springframework.http.ResponseEntity;
import uz.pdp.ecommersapp.entity.Cart;
import uz.pdp.ecommersapp.entity.User;
import uz.pdp.ecommersapp.payload.CartAdressSetReq;
import uz.pdp.ecommersapp.payload.CartProductReq;
import uz.pdp.ecommersapp.payload.Result;

public interface CartService {
    void createCart(User user);
    ResponseEntity<Cart> getCart(User user);
//    ResponseEntity<Cart>deleteProductFromCart(Integer id);
    ResponseEntity<Result> addProducts(CartProductReq cartProductReq, User user);
    ResponseEntity<Result> addAdress(CartAdressSetReq cartAdressSetReq, User user);

}
