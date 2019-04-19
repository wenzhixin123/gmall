package com.xinxin.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xinxin.gmall.bean.SkuInfo;
import com.xinxin.gmall.service.SkuInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SkuManageController {

    @Reference
    SkuInfoService skuInfoService;

    @RequestMapping("skuInfoListBySpu")
    @ResponseBody
    public List<SkuInfo> skuInfoListBySpu(String spuId){
        List<SkuInfo> skuInfos = skuInfoService.skuInfoListBySpu(spuId);
        return skuInfos;
    }

    @RequestMapping("saveSku")
    @ResponseBody
    public boolean saveSku(SkuInfo skuInfo){
       boolean result = skuInfoService.saveSku(skuInfo);
       return result;
    }

}
