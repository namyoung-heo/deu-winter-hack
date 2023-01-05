package com.example.repository;

import com.example.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CartEntity, Long> {
}
