package com.wurain.user.repository;

import java.util.List;

import com.wurain.user.model.User;

public interface UserRepository {

    public List<User> findAll();
    public User findById(long id);
    public void save(User user);
    public void update(User user);
    public void deleteById(long id);
}
