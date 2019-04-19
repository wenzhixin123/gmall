package com.xinxin.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xinxin.gmall.bean.*;
import com.xinxin.gmall.manage.util.UploadUtil;
import com.xinxin.gmall.service.SpuInfoService;
import org.csource.common.MyException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
public class SpuManageController {

    @Reference
    SpuInfoService spuInfoService;

    @Value("${tracker.conf.path}")
    String trackerConfPath;

    @Value("${fileServer.url}")
    String fileServerUrl;

    @RequestMapping("attrInfoList")
    @ResponseBody
    public List<BaseAttrInfo> attrInfoList(String catalog3Id){

        List<BaseAttrInfo> baseAttrInfos = spuInfoService.attrInfoList(catalog3Id);

        return baseAttrInfos;
    }

    @RequestMapping("spuSaleAttrList")
    @ResponseBody
    public List<SpuSaleAttr> spuSaleAttrList(String spuId){

        List<SpuSaleAttr> spuSaleAttrs = spuInfoService.spuSaleAttrList(spuId);

        return spuSaleAttrs;
    }

    @RequestMapping("spuImageList")
    @ResponseBody
    public List<SpuImage> spuImageList(String spuId){

        List<SpuImage> spuImages = spuInfoService.spuImageList(spuId);

        return spuImages;
    }


    @RequestMapping("/fileUpload")
    @ResponseBody
    public String fileUpload(MultipartFile file) throws IOException, MyException {

        String uploadPath = UploadUtil.uploadFile(trackerConfPath, file, file.getOriginalFilename(), fileServerUrl);

        System.out.println(uploadPath);

        return uploadPath;
    }



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

    @RequestMapping("saveSpu")
    @ResponseBody
    public boolean saveSpu(SpuInfo spuInfo){
        boolean result = spuInfoService.saveSpu(spuInfo);
        return result;
    }

}
