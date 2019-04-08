package com.xinxin.gmall.service;

import com.xinxin.gmall.bean.UserInfo;

import java.util.List;

public interface UserInfoService {

    public List<UserInfo> getUserInfoListAll();

    public UserInfo getUserInfo(String id);

    public int addUser(UserInfo userInfo);

    public int updateUser(String id, UserInfo userInfo);

    public int deleteUser(String id);

    public UserInfo login(UserInfo userInfo);

    public UserInfo verify(String userId);


}
