package com.fmi.merchandise.repository;

import com.fmi.merchandise.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepoImpl implements UserRepository {
    @Override
    public User findById(Long id) {

    }

    @Override
    public boolean createUser(User user) {

    }

    @Override
    public boolean removeUser(Long id) {
        
    }
}
