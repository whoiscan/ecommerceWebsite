package uz.pdp.ecommersapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.pdp.ecommersapp.entity.*;
import uz.pdp.ecommersapp.payload.CartAdressSetReq;
import uz.pdp.ecommersapp.payload.CartProductReq;
import uz.pdp.ecommersapp.payload.Result;
import uz.pdp.ecommersapp.repository.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    AdressRepository adressRepository;

    @Autowired
    RegionRepository regionRepository;

    @Autowired
    DistrictRepository districtRepository;

    @Override
    public ResponseEntity<Cart> getCart(User user) {
        Optional<Cart> optionalCart = cartRepository.getByUser(user);
        if (optionalCart.isPresent()) {
            Cart cart = optionalCart.get();
            return ResponseEntity.ok(cart);
        }
        return ResponseEntity.status(500).build();
    }

    @Override
    public void createCart(User user) {
        Optional<Cart> optionalCart = cartRepository.getByUser(user);
        if (!optionalCart.isPresent()) {
            Cart cart = new Cart();
            cart.setUser(user);
            cartRepository.save(cart);
        }

    }

    @Override
    public ResponseEntity<Result> addProducts(CartProductReq cartProductReq, User user) {
        Optional<Cart> optionalCart = cartRepository.getByUser(user);
        Result result = new Result();
        if (optionalCart.isPresent()) {
            Cart cart = optionalCart.get();
            List<Product> products = new ArrayList<>();
            cartProductReq.getProductIds().forEach(integer -> {
                Optional<Product> optionalProduct = productRepository.findById(integer);
                if (optionalProduct.isPresent()) {
                    Product product = optionalProduct.get();
                    products.add(product);
                }
            });
            cart.setProducts(products);
            result.setSuccess(true);
            result.setMessage("Products successufully added to cart");
            return ResponseEntity.ok(result);
        } else {
            result.setSuccess(false);
            result.setMessage("Product not saved");
            return ResponseEntity.status(500).body(result);
        }
    }

    @Override
    public ResponseEntity<Result> addAdress(CartAdressSetReq cartAdressSetReq, User user) {
        Optional<Cart> optionalCart = cartRepository.getByUser(user);
        Result result=new Result();
        if (optionalCart.isPresent()) {
            Cart cart=optionalCart.get();
            cart.setDeliverType(cartAdressSetReq.isDeliverType());
            Adress adress=new Adress();
            Optional<Region>optionalRegion=regionRepository.findById(cartAdressSetReq.getRegionId());
            if (optionalRegion.isPresent()){
                Region region=optionalRegion.get();
                adress.setRegion(region);
            }else {
                result.setSuccess(false);
                result.setMessage("wrong region");
                return ResponseEntity.status(400).body(result);
            }
            Optional<District>optionalDistrict=districtRepository.findById(cartAdressSetReq.getDistrictId());
            if (optionalDistrict.isPresent()){
                District district=optionalDistrict.get();
                adress.setDistrict(district);
            }else {
                result.setSuccess(false);
                result.setMessage("wrong district");
                return ResponseEntity.status(400).body(result);
            }
            adress.setFloor(cartAdressSetReq.getFloor());
            adress.setHomeNumber(cartAdressSetReq.getHomeNumber());
            adress.setHouse(cartAdressSetReq.getHouse());
            adress.setPodyezd(cartAdressSetReq.getPodyezd());
            adress.setStreet(cartAdressSetReq.getStreet());
            Adress newadress=adressRepository.save(adress);
            if (newadress != null) {
                cart.setAdress(newadress);
                result.setSuccess(true);
                result.setMessage("adress  saved successfully");
                return ResponseEntity.ok(result);
            }
           else {
                result.setSuccess(false);
                result.setMessage("adress not saved");
                return ResponseEntity.status(500).body(result);

            }

        }else {
            result.setSuccess(false);
            result.setMessage("error cart");
            return ResponseEntity.status(400).body(result);

        }
    }
}
