package com.imcjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ImcJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImcJavaApplication.class, args);
    }


    //creating roles
//    public CommandLineRunner commandLineRunner(RoleRepository roleRepository) {
//        return args -> {
//            var adminRole = new Role();
//            adminRole.setName("admin");
//            roleRepository.save(adminRole);
//
//            var customerRole = new Role();
//            customerRole.setName("admin");
//            roleRepository.save(customerRole);
//
//            var spRole = new Role();
//            spRole.setName("admin");
//            roleRepository.save(spRole);
//        };
//    }
}
