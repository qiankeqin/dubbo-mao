package com.stylefeng.guns.rest.modular.user;

import com.stylefeng.guns.facade.user.UserAPI;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-03-17 22:54
 */
@RestController
public class UserClientController {

    @Reference
    private UserAPI userAPI;

    @RequestMapping(value="/client/login",method= RequestMethod.POST)
    public String clinetLogin(@RequestParam(name="username") String username,@RequestParam(name="password") String password){
        userAPI.login(username,password);
        return "success";
    }
}