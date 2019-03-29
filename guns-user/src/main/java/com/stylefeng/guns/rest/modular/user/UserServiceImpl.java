package com.stylefeng.guns.rest.modular.user;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.core.util.MD5Util;
import com.stylefeng.guns.facade.user.vo.UserInfoModel;
import com.stylefeng.guns.facade.user.vo.UserModel;
import com.stylefeng.guns.facade.user.UserAPI;
import com.stylefeng.guns.rest.common.persistence.dao.MoocUserTMapper;
import com.stylefeng.guns.rest.common.persistence.model.MoocUserT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-03-17 20:43
 */
@Component
@Service(interfaceClass = UserAPI.class,loadbalance = "roundrobin")
public class UserServiceImpl implements UserAPI {

    @Autowired
    private MoocUserTMapper moocUserTMapper;

    @Override
    public int login(String userName, String password) {
        //根据登录账号获取数据库信息
        MoocUserT moocUserT = new MoocUserT();
        moocUserT.setUserName(userName);

        MoocUserT moocUserT_exist = moocUserTMapper.selectOne(moocUserT);
        //对获取的信息和登录输入的信息做比较
        if(null!=moocUserT_exist && moocUserT_exist.getUuid()>0){
            String md5Password = MD5Util.encrypt(password);
            if(md5Password.equals(moocUserT_exist.getUserPwd())){
                return moocUserT_exist.getUuid();
            }
        }

        return 0;
    }

    @Override
    public boolean register(UserModel userModel) {
        //获取注册信息

        //将注册信息实体转为数据实体
        MoocUserT moocUserT = new MoocUserT();
        moocUserT.setUserName(userModel.getUsername());
        moocUserT.setUserPhone(userModel.getPhone());
        moocUserT.setEmail(userModel.getEmail());
        moocUserT.setAddress(userModel.getAddress());
        //md5+盐 -》 shiro加密
        String md5Password = MD5Util.encrypt(userModel.getPassword());
        moocUserT.setUserPwd(md5Password);

        //创建时间和修改时间 --> 直接使用数据库的时间

        //存储数据实体
        Integer insert = moocUserTMapper.insert(moocUserT);
        if(insert>0){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean checkUsername(String username) {
        EntityWrapper<MoocUserT> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("user_name",username);
        Integer count = moocUserTMapper.selectCount(entityWrapper);
        if(null!=count && count>0){
            return false;
        }
        return true;
    }

    private UserInfoModel do2UserInfo(MoocUserT userT){
        UserInfoModel userInfoModel = new UserInfoModel();

        userInfoModel.setUsername(userT.getUserName());
        userInfoModel.setSex(userT.getUserSex());
        userInfoModel.setUpdateTime(userT.getUpdateTime().getTime());
        userInfoModel.setPhone(userT.getUserPhone());
        userInfoModel.setNickname(userT.getNickName());
        userInfoModel.setLifeState(userT.getLifeState()+"");
        userInfoModel.setHeadAddress(userT.getHeadUrl());
        userInfoModel.setEmail(userT.getEmail());
        userInfoModel.setBirthday(userT.getBirthday());
        userInfoModel.setBiography(userT.getBiography());
        userInfoModel.setBeginTime(userT.getBeginTime().getTime());
        userInfoModel.setAddress(userT.getAddress());

        return userInfoModel;
    }

    @Override
    public UserInfoModel getUserInfo(int uuid) {
        MoocUserT moocUserT = new MoocUserT();
        moocUserT.setUuid(uuid);
        moocUserT = moocUserTMapper.selectOne(moocUserT);
        return do2UserInfo(moocUserT);
    }

    @Override
    public UserInfoModel updateUserInfo(UserInfoModel userInfoModel) {
        //构造MoocUserT
        MoocUserT moocUserT = new MoocUserT(){{
            setUuid(userInfoModel.getUuid());
            setUserSex(userInfoModel.getSex());
            setUpdateTime(new Date());
            setNickName(userInfoModel.getNickname());
            setLifeState(Integer.parseInt(userInfoModel.getLifeState()));
            setHeadUrl(userInfoModel.getHeadAddress());
            setBirthday(userInfoModel.getBirthday());
            setBiography(userInfoModel.getBiography());
            setBeginTime(time2Date(userInfoModel.getBeginTime()));
            setUserPhone(userInfoModel.getPhone());
            setEmail(userInfoModel.getEmail());
            setAddress(userInfoModel.getAddress());
        }};
        //将数据存入数据库
        Integer success = moocUserTMapper.updateById(moocUserT);
        if(success>0){
            //按照Id将用户信息查出来
            UserInfoModel userInfo = getUserInfo(userInfoModel.getUuid());
            //返回
            return userInfo;
        }
        return userInfoModel;
    }

    private Date time2Date(long time){
        Date date = new Date(time);
        return date;
    }
}