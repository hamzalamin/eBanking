package com.wora.ebanking.repositoies;

import com.wora.ebanking.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
