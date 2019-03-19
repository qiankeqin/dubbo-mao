package com.stylefeng.guns.rest.common;

import com.stylefeng.guns.facade.model.UserInfoModel;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-03-18 20:53
 */
public class CurrentUser {

    private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void saveUserId(String userId){
        threadLocal.set(userId);
    }

    public static String getUserId(){
        return threadLocal.get();
    }

    public static void clear(){
        threadLocal.remove();
    }

//    //线程绑定的存储空间
//    private static final ThreadLocal<UserInfoModel> threadLocal = new ThreadLocal<>();
//
//    //存储用户信息
//    public static void saveUserInfo(UserInfoModel userInfoModel){
//        threadLocal.set(userInfoModel);
//    }
//
//    //取出用户信息
//    public static UserInfoModel getUserInfo(){
//        return threadLocal.get();
//    }
//
//    //清除用户信息
//    public static void clearUserInfo(){
//        threadLocal.remove();
//    }
}