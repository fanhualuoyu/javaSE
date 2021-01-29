package cn.zh.dao;

import cn.zh.domain.User;

import java.util.List;

public interface IUSerDao {
    /**
     * 查询所有的操作
     * @return
     */
    List<User> findAll();
}
