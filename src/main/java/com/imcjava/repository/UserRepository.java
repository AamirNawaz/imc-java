package com.imcjava.repository;

import com.imcjava.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);

    @Query(value = "SELECT id FROM imc_users WHERE email =:email", nativeQuery = true)
    Optional<String> getUserIdByEmail(@Param("email") String email);
}
