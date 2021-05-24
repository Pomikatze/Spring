package com.geekbrains.market.repo;

import com.geekbrains.market.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findOneByUserName (String username);
}
