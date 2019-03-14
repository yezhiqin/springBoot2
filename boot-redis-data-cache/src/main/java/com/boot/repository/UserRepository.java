package com.boot.repository;

import com.boot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 用户接口
 * Created by zhoujh on 2018/7/19.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
    User findByUserNameOrEmail(String username, String email);
    List<User> findByNickname(String nickname);
}