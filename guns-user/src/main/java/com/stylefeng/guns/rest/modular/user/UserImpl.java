package com.stylefeng.guns.rest.modular.user;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.facade.model.UserInfoModel;
import com.stylefeng.guns.facade.model.UserModel;
import com.stylefeng.guns.facade.user.UserAPI;
import org.springframework.stereotype.Component;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-03-17 20:43
 */
@Component
@Service(interfaceClass = UserAPI.class)
public class UserImpl implements UserAPI {

    @Override
    public int login(String userName, String password) {
        System.out.println("this is user module！！！"+userName+"&"+password);
        return 1;
    }

    @Override
    public boolean register(UserModel userModel) {
        return false;
    }

    @Override
    public boolean checkUsername(String username) {
        return false;
    }

    @Override
    public UserInfoModel getUserInfo(int uuid) {
        return null;
    }

    @Override
    public UserInfoModel updateUserInfo(UserInfoModel userInfoModel) {
        return null;
    }
}