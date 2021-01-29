package cn.zh.dao;

import cn.zh.domain.DoubleUser;
import cn.zh.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.javassist.bytecode.LineNumberAttribute;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * 在mybatis中针对CRUD一共有四个注解
 * @SELECT @INSERT @UPDATE @DELETE
 */
public interface IUserDao {
    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from user")
    @Results(id = "userMap",value = {
            @Result(id=true,column = "id",property = "userId"),
            @Result(column = "username",property = "userName"),
            @Result(column = "address",property = "userAddress"),
            @Result(column = "sex",property = "userSex"),
            @Result(column = "birthday",property = "userBirthday"),
            @Result(property = "accounts",column = "id",
                    many = @Many(select = "cn.zh.dao.IAccountDao.findAccountByUid",fetchType = FetchType.LAZY))
    })
    List<DoubleUser> findAll();


    /**
     * 查找一个用户
     * @param userId
     * @return
     */
    @Select("select * from user where id=#{id}")
    @ResultMap("userMap")
    DoubleUser findById(Integer userId);

    /**
     * 根据用户名模糊查询
     * @param username
     * @return
     */
    @Select("select * from user where username like #{username}")
    @ResultMap("userMap")
    List<DoubleUser> findUserByName(String username);

}
