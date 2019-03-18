package com.stylefeng.guns.rest.modular.user;

import com.stylefeng.guns.facade.user.UserAPI;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.stereotype.Component;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-03-17 22:52
 */
@Component
public class UserClient {

    @Reference
    private UserAPI userAPI;

    public void run(){
        userAPI.login("admin","admin");
    }
}