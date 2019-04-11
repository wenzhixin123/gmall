package com.xinxin.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xinxin.gmall.bean.BaseSaleAttr;
import com.xinxin.gmall.bean.SpuInfo;
import com.xinxin.gmall.bean.SpuSaleAttrValue;
import com.xinxin.gmall.service.SpuInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SpuManageController {

    @Reference
    SpuInfoService spuInfoService;

    @RequestMapping("spuListPage")
    public String gotoSpuListPage(){
        return "spuListPage";
    }

    @RequestMapping("spuList")
    @ResponseBody
    public List<SpuInfo> spuInfoList(String catalog3Id){

        List<SpuInfo> spuInfos = spuInfoService.spuInfoList(catalog3Id);

        return spuInfos;
    }

    @RequestMapping("baseSaleAttrList")
    @ResponseBody
    public List<BaseSaleAttr> baseSaleAttrList(){

        List<BaseSaleAttr> attrs = spuInfoService.getBaseSaleAttr();
        return attrs;
    }



}
