package com.kakaopay.shy.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kakaopay.shy.model.Product;
import com.kakaopay.shy.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findById(Long id);
	User save(User u);
}
