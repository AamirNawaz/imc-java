package com.imcjava.services.user;

import com.imcjava.models.Role;
import com.imcjava.models.User;
import com.imcjava.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MyUserService implements UserDetailsService {
    private final UserRepository userRepository;

    public MyUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User myUser = userRepository.findByEmail(email)
                .orElseThrow(()->new UsernameNotFoundException("Email not found!"));

        //Now fetching role from User entity
        Set<Role> roles = myUser.getRoles();
        System.out.println("Roles for user " + email + ": " + roles);

        //Create collection type variable which stores roles list.
        Collection<SimpleGrantedAuthority> authorities = roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());

        //here pass email, pass and authorites to Spring builtin User as params
        return new org.springframework.security.core.userdetails.User(myUser.getEmail(),myUser.getPassword(),authorities);


    }
}
