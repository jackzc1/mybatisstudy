package com.soft.dao;

import com.soft.entity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * Created by Administrator on 2020/2/9.
 * 注解方式的crud
 */
//开启2及缓存
@CacheNamespace(blocking = true)
public interface UserDao1 {
    @Select("select * from user where id = #{id}")
    public User findById(Integer id);

    @Insert("insert into user values(null,#{username},#{birthday},#{sex},#{address})")
    public void insertUser(User user);

    @Update("update user set username=#{username},birthday=#{birthday},sex=#{sex},address=#{address} where id=#{id}")
    public void updateUser(User user);

    @Delete("delete from user where id = #{id}")
    public void deleteUser(Integer id);

    @Select("select * from user where id = #{id}")
    @Results(id = "re1", value = {
            @Result(column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "birthday", property = "birthday"),
            @Result(column = "sex", property = "sex"),
            @Result(column = "address", property = "address"),
    @Result(property = "accounts", column = "id",
            many = @Many(select = "com.soft.dao.AccountDao1.findByUid",
                    fetchType = FetchType.LAZY))})
    public User findByid1(int id);

}
