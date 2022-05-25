package com.fmi.merchandise.repository;

import com.fmi.merchandise.model.User;

public interface UserRepository {

    public User findById(Long id);

    public boolean createUser(User user);

    public boolean removeUser(Long id);
}
