package cn.zh.dao;

import cn.zh.domain.User;

import java.util.List;

public interface IUserDao {
    /**
     * 查询所有的用户,同时获取用户的所有账户信息
     * @return
     */
    List<User> findAll();

    /**
     * 根据id查询用户信息
     * @param userId
     * @return
     */
    User findById(Integer userId);
}
