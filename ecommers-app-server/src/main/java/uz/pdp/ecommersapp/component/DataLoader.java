package uz.pdp.ecommersapp.component;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import uz.pdp.ecommersapp.entity.User;
import uz.pdp.ecommersapp.repository.RoleRepository;
import uz.pdp.ecommersapp.repository.UserRepository;

@Component
public class DataLoader implements CommandLineRunner {
    @Value("${spring.datasource.initialization-mode}")
    String initialMode;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (initialMode.equals("always")) {
            userRepository.save(new User("superAdmin","superadmin@gmail.com", passwordEncoder.encode("193045"),
                    "Adminstrator",roleRepository.findAll()));
        }
    }
}
