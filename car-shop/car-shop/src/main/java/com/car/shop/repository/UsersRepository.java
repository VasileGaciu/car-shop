package com.car.shop.repository;

import com.car.shop.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, String> {
    public Optional<Users> findByUsername(String username);
    public Boolean existsByUsername(String username);
}
