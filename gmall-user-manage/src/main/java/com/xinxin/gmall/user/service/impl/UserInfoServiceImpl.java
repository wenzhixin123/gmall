package com.xinxin.gmall.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xinxin.gmall.bean.UserInfo;
import com.xinxin.gmall.user.mapper.UserInfoMapper;
import com.xinxin.gmall.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> getUserInfoListAll() {
        return userInfoMapper.selectAll();
    }

    @Override
    public UserInfo getUserInfo(String id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int addUser(UserInfo userInfo) {
        int insert = userInfoMapper.insert(userInfo);
        return insert;
    }

    @Override
    public int updateUser(String id, UserInfo userInfo) {
        userInfo.setId(id);
        int i = userInfoMapper.updateByPrimaryKeySelective(userInfo);
        return i;
    }

    @Override
    public int deleteUser(String id) {
        int i = userInfoMapper.deleteByPrimaryKey(id);
        return i;
    }


    @Override
    public UserInfo login(UserInfo userInfo) {
        return null;
    }

    @Override
    public UserInfo verify(String userId) {
        return null;
    }
}
