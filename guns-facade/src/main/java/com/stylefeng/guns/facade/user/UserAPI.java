package com.stylefeng.guns.facade.user;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-03-17 20:42
 */
public interface UserAPI {
    /**
     * 登录
     * @param userName
     * @param password
     * @return
     */
    boolean login(String userName, String password);
}