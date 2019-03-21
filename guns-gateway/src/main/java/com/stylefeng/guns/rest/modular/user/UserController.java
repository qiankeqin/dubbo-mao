package com.stylefeng.guns.rest.modular.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.facade.model.UserInfoModel;
import com.stylefeng.guns.facade.model.UserModel;
import com.stylefeng.guns.facade.user.UserAPI;
import com.stylefeng.guns.rest.common.CurrentUser;
import com.stylefeng.guns.rest.modular.vo.ResponseVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiankeqin
 * @Description: 用户操作
 * @date 2019-03-20 13:21
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @Reference
    private UserAPI userAPI;

    /**
     * 注册
     * @param userModel
     * @return
     */
    @PostMapping("/register")
    public ResponseVO register(UserModel userModel){
        if(StringUtils.isBlank(userModel.getUsername())){
            return ResponseVO.serviceFail("用户名不能为空");
        }
        if(StringUtils.isBlank(userModel.getPassword())){
            return ResponseVO.serviceFail("密码不能为空");
        }
        boolean register = userAPI.register(userModel);
        if(register){
            return ResponseVO.success("注册成功");
        } else {
            return ResponseVO.serviceFail("注册失败");
        }
    }

    /**
     * 用户名验证
     * @param userName
     * @return
     */
    @PostMapping("/check")
    public ResponseVO check(String userName){
        if(StringUtils.isBlank(userName)){
            return ResponseVO.serviceFail("用户名必须存在");
        }
        boolean isOk = userAPI.checkUsername(userName);
        if(isOk){
            return ResponseVO.success("用户名可用");
        } else {
            return ResponseVO.serviceFail("用户名已存在");
        }
    }

    /**
     * 登出
     * @return
     */
    @GetMapping("/logout")
    public ResponseVO logout(){
        /**
         * 应用：
         *  1。前端存储JWT【7天】：JWT刷新
         *  2。服务端会存储活动用户信息【30分钟】
         *  3。JWT里面的userId为key，查询活跃用户
         *
         *  正式的退出有两步骤：
         *      1。前端删除JWT
         *      2。后端服务器删除活跃用户缓存
         *
         *  现状：
         *      1。前端删除JWT
         */



        return ResponseVO.success("用户退出成功");
    }

    /**
     * 获取用户信息
     * @return
     */
    @GetMapping("/getUserInfo")
    public ResponseVO getUserInfo(){
        //获取当前登录用户
        String userId = CurrentUser.getUserId();
        if(StringUtils.isNotBlank(userId)){
            //将用户id传入后端查询
            int uuid = Integer.parseInt(userId);
            UserInfoModel userInfo = userAPI.getUserInfo(uuid);
            if(null!=userInfo){
                return ResponseVO.success(userInfo);
            } else {
                return ResponseVO.serviceFail("用户信息查询失败");
            }
        } else {
            return ResponseVO.serviceFail("用户未登录");
        }
    }


    /**
     * 获取用户信息
     * @return
     */
    @PostMapping("/updateuserInfo")
    public ResponseVO updateuserInfo(UserInfoModel userInfoModel){
        //获取当前登录用户
        String userId = CurrentUser.getUserId();
        if(StringUtils.isNotBlank(userId)){
            //将用户id传入后端查询
            int uuid = Integer.parseInt(userId);
            //判断传入的id和登录的id是否一致，不一致可能存在串改的嫌疑
            if(uuid != userInfoModel.getUuid()){
                return ResponseVO.serviceFail("修改的用户非当前登录用户");
            }
            UserInfoModel userInfo = userAPI.updateUserInfo(userInfoModel);
            if(null!=userInfo){
                return ResponseVO.success(userInfo);
            } else {
                return ResponseVO.serviceFail("用户信息查询失败");
            }
        } else {
            return ResponseVO.serviceFail("用户未登录");
        }
    }
}