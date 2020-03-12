package com.wurain.user.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.wurain.user.model.User;
import com.wurain.user.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("select * from users", new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public User findById(long id) {
        return jdbcTemplate.queryForObject("select * from users where id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public void save(User user) {
        jdbcTemplate.update("insert into users(name, age) values(?, ?)", user.getName(), user.getAge());

    }

    @Override
    public void update(User user) {
        jdbcTemplate.update("update users set name = ?, age = ? where id = ?", user.getName(), user.getAge(), user.getId());
    }

    @Override
    public void deleteById(long id) {
        jdbcTemplate.update("delete from users where id = ?", id);
    }

}
