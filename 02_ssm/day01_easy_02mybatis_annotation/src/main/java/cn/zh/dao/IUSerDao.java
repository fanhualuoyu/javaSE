package cn.zh.dao;

import cn.zh.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUSerDao {
    /**
     * 查询所有的操作
     * @return
     */
    @Select("select * from user")
    List<User> findAll();
}
