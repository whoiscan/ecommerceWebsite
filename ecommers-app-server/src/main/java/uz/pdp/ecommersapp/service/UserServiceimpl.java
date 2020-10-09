package uz.pdp.ecommersapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.pdp.ecommersapp.entity.User;
import uz.pdp.ecommersapp.repository.UserRepository;

import java.util.Optional;

@Service
public class UserServiceimpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional <User> optional=userRepository.findByUsernameOrEmail(username,username);
        return optional.orElseThrow(()->new UsernameNotFoundException(username));
    }
}
