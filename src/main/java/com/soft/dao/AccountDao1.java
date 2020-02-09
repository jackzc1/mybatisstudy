package com.soft.dao;

import com.soft.entity.Account;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2020/2/9.
 */
public interface AccountDao1 {


    //根据uid查
    @Select("select * from account where uid = #{uid}")
    public List<Account> findByUid(int uid);
}
