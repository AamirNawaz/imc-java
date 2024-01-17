package com.imcjava.services.user;

import com.imcjava.dto.userDto.SignupRequest;
import com.imcjava.models.Role;
import com.imcjava.models.User;
import com.imcjava.repository.RoleRepository;
import com.imcjava.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MyUserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public MyUserService(@Lazy UserRepository userRepository, @Lazy PasswordEncoder passwordEncoder, @Lazy RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User myUser = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Email not found!"));

        //Now fetching role from User entity
        Set<Role> roles = myUser.getRoles();
        System.out.println("Roles for user " + email + ": " + roles);

        //Create collection type variable which stores roles list.
        Collection<SimpleGrantedAuthority> authorities = roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());

        //here pass email, pass and authorites to Spring builtin User as params
        return new org.springframework.security.core.userdetails.User(myUser.getEmail(), myUser.getPassword(), authorities);


    }

    public ResponseEntity<String> signup(SignupRequest signupRequest) {
        try {
            User newUser = new User();
            newUser.setName(signupRequest.getName());
            newUser.setEmail(signupRequest.getEmail());
            String hashPassword = passwordEncoder.encode(signupRequest.getPassword());
            newUser.setPassword(hashPassword);
            newUser.setIsDeleted(signupRequest.getIsDeleted());

            Set<Role> roles = new HashSet<>();
            for (String roleName : signupRequest.getRoles()) {
                Role role = roleRepository.findByName(roleName)
                        .orElseThrow(() -> new EntityNotFoundException("Role with name" + roleName + "not found!"));
                roles.add(role);
            }
            newUser.setRoles(roles);
            userRepository.save(newUser);
            return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getLocalizedMessage());
        }
    }
}
