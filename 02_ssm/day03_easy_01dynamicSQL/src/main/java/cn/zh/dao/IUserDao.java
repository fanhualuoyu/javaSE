package cn.zh.dao;

import cn.zh.domain.QueryVo;
import cn.zh.domain.User;

import java.util.List;

public interface IUserDao {
    /**
     * 查询所有的用户
     * @return
     */
    List<User> findAll();

    /**
     * 根据id查询用户信息
     * @param userId
     * @return
     */
    User findById(Integer userId);

    /**
     * 根据名称模糊查询
     * @param username
     * @return
     */
    List<User> findByName(String username);


    /**
     * 根据QueryVo查询
     * @param vo
     * @return
     */
    List<User> findUserByVo(QueryVo vo);

    /**
     * 根据传入参数条件查询
     * @param user  查询的条件
     * @return
     */
    List<User> findUserByCondition(User user);

    /**
     * 根据in查询
     * @param vo
     * @return
     */
    List<User> findUserByInIds(QueryVo vo);
}
