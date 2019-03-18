package com.stylefeng.guns.facade.user;

import com.stylefeng.guns.facade.model.UserInfoModel;
import com.stylefeng.guns.facade.model.UserModel;

/**
 * @author qiankeqin
 * @Description: 用户接口
 * @date 2019-03-17 20:42
 */
public interface UserAPI {
    /**
     * 登录
     * @param userName
     * @param password
     * @return
     */
    int login(String userName, String password);

    /**
     * 注册
     * @param userModel
     * @return
     */
    boolean register(UserModel userModel);

    /**
     * 判断用户是否存在
     * @param username
     * @return
     */
    boolean checkUsername(String username);

    /**
     * 获取用户信息
     * @param uuid
     * @return
     */
    UserInfoModel getUserInfo(int uuid);

    /**
     * 更新用户信息
     * @param userInfoModel
     * @return
     */
    UserInfoModel updateUserInfo(UserInfoModel userInfoModel);
}