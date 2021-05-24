package com.geekbrains.market.service;

import com.geekbrains.market.dao.SystemUser;
import com.geekbrains.market.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User findByUserName(String username);
    boolean save(SystemUser systemUser);

}
