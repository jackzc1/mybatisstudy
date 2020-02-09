package com.soft.dao;

import com.soft.entity.Account;

import java.util.List;

/**
 * Created by Administrator on 2020/2/9.
 */
public interface AccountDao {

    public List<Account> findAll();

    //根据uid查
    public List<Account> findByUid(int uid);
}
