package com.xinxin.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.xinxin.gmall.bean.*;
import com.xinxin.gmall.service.ManageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class AttrManageController {

    @Reference
    private ManageService manageService;

    @RequestMapping("/attrListPage")
    public String getAttrListPage(){
        return "attrListPage";
    }

    @RequestMapping("getCatalog1")
    @ResponseBody
    public List<BaseCatalog1> getCatalog1(){
        List<BaseCatalog1> catalog1 = manageService.getCatalog1();
        return catalog1;
    }


    @RequestMapping("getCatalog2")
    @ResponseBody
    public List<BaseCatalog2> getCatalog2(String catalog1Id){
        List<BaseCatalog2> catalog2 = manageService.getCatalog2(catalog1Id);
        return catalog2;
    }

    @RequestMapping("getCatalog3")
    @ResponseBody
    public List<BaseCatalog3> getCatalog3(String catalog2Id){
        List<BaseCatalog3> catalog3 = manageService.getCatalog3(catalog2Id);
        return catalog3;
    }

    @RequestMapping("getAttrList")
    @ResponseBody
    public List<BaseAttrInfo> getAttrList(String catalog3Id){
        List<BaseAttrInfo> baseAttrInfos = manageService.getAttrList(catalog3Id);
        return baseAttrInfos;
    }

    @RequestMapping("getAttrValueList")
    @ResponseBody
    public List<BaseAttrValue> getAttrValueList(@RequestParam Map<String,Object> map){
        String attrId = (String) map.get("attrId");

        BaseAttrInfo attrInfo = manageService.getAttrInfo(attrId);

        return attrInfo.getAttrValueList();
    }

    @RequestMapping(value = "saveAttrInfo",method = RequestMethod.POST)
    @ResponseBody
    public boolean saveAttrInfo(BaseAttrInfo baseAttrInfo){

        return manageService.saveAttrInfo(baseAttrInfo);
    }


}
