package com.uncledavecode.springsecurity.repositories;

import com.uncledavecode.springsecurity.model.Authority;
import com.uncledavecode.springsecurity.utils.AuthorityName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Optional<Authority> findByName(AuthorityName name);
}
