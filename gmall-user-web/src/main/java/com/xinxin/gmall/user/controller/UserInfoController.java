package com.xinxin.gmall.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xinxin.gmall.bean.UserInfo;
import com.xinxin.gmall.service.UserInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserInfoController {

    @Reference
    private UserInfoService userInfoService;

    @GetMapping("/userInfos")
    public ResponseEntity<List<UserInfo>> getUserInfoList(){
        List<UserInfo> all = userInfoService.getUserInfoListAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/userInfos/{id}")
    public ResponseEntity<UserInfo> getUserInfo(@PathVariable(value = "id") String id){
        UserInfo userInfo = userInfoService.getUserInfo(id);
        return ResponseEntity.ok(userInfo);
    }


    @PostMapping("/userInfos")
    public Boolean addUserInfo(@RequestBody UserInfo userInfo){
        int i = userInfoService.addUser(userInfo);
        if (i > 0) return true;
        return false;
    }
    @PutMapping("/userInfos/{id}")
    public Boolean updateUserInfo(@PathVariable(value = "id") String id,@RequestBody UserInfo userInfo){
        int i = userInfoService.updateUser(id,userInfo);
        if (i > 0) return true;
        return false;
    }
    @DeleteMapping("/userInfos/{id}")
    public Boolean deleteUserInfo(@PathVariable(value = "id") String id){
        int i = userInfoService.deleteUser(id);
        if (i > 0) return true;
        return false;
    }



}
