package com.imcjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ImcJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImcJavaApplication.class, args);
    }


//    @Bean
//    public CommandLineRunner commandLineRunner(RoleRepository roleRepository) {
//        return args -> {
//            var adminRole = new Role();
//            adminRole.setName("ROLE_ADMIN");
//            roleRepository.save(adminRole);
//
//            var customerRole = new Role();
//            customerRole.setName("ROLE_CUSTOMER");
//            roleRepository.save(customerRole);
//
//            var spRole = new Role();
//            spRole.setName("ROLE_SP");
//            roleRepository.save(spRole);
//        };
//    }


}
