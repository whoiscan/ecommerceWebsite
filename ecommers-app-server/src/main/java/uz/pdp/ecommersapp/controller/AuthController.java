package uz.pdp.ecommersapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import uz.pdp.ecommersapp.entity.Role;
import uz.pdp.ecommersapp.entity.User;
import uz.pdp.ecommersapp.payload.JwtResponse;
import uz.pdp.ecommersapp.payload.LoginReq;
import uz.pdp.ecommersapp.payload.UserReq;
import uz.pdp.ecommersapp.repository.RoleRepository;
import uz.pdp.ecommersapp.repository.UserRepository;
import uz.pdp.ecommersapp.security.CurrentUser;
import uz.pdp.ecommersapp.security.JwtProvider;
import uz.pdp.ecommersapp.service.CartService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URI;
import java.util.Collections;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    CartService cartService;
    @RequestMapping(value = "/signin",method = RequestMethod.POST)
    public ResponseEntity<?> signIn(@Valid @RequestBody LoginReq loginReq){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginReq.getUsername(),
                        loginReq.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
       Optional<User> optionalUser=userRepository.findByUsernameOrEmail(loginReq.getUsername(),loginReq.getUsername());

       if (optionalUser.isPresent()){
           User user=optionalUser.get();

        cartService.createCart(user);

       }
        String jwt = jwtProvider.generateJwtToken(authentication);
        return ResponseEntity.ok(new JwtResponse(jwt));
    }
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@Valid @RequestBody UserReq userReq, HttpServletResponse response){
        if(userRepository.existsByUsername(userReq.getUsername())) {
            return new ResponseEntity<String>("Fail -> Username is already taken!",
                    HttpStatus.BAD_REQUEST);
        }

        if(userRepository.existsByEmail(userReq.getEmail())) {
            return new ResponseEntity<String>("Fail -> Email is already in use!",
                    HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        User user = new User(userReq.getName(), userReq.getUsername(),
                userReq.getEmail(), userReq.getPassword());

        user.setPassword(encoder.encode(user.getPassword()));

        Role userRole = roleRepository.findByName("ROLE_USER")
                .orElseThrow(() -> new RuntimeException("User Role not set."));

        user.setRoles(Collections.singletonList(userRole));

        User result = userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/users/{username}")
                .buildAndExpand(result.getUsername()).toUri();
//         response.
        return ResponseEntity.ok().body("User registered successfully!");
    }
    @GetMapping("/user")
    public User getUser(@CurrentUser User user){
        return user;
    }

}
