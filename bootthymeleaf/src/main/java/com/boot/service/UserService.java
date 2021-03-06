package com.boot.service;

import com.boot.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @Description: 接口
 * @Author: yezhiqin
 * @CreateDate: 2018/6/17$ 上午11:27$
 * @Version: 1.0
 */
public interface UserService extends JpaRepository<User,Long>{

    @Query("select u from User u")
    Page<User> findList(Pageable pageable);

    User findUserById(long id);

    User findByUserName(String userName);

    void deleteUserById(Long id);
}
