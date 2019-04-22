package com.xinxin.gmall.item.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.xinxin.gmall.bean.SkuInfo;
import com.xinxin.gmall.bean.SkuSaleAttrValue;
import com.xinxin.gmall.bean.SpuSaleAttr;
import com.xinxin.gmall.service.SkuInfoService;
import com.xinxin.gmall.service.SpuInfoService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ItemController {

    @Reference
    SkuInfoService skuInfoService;

    @Reference
    SpuInfoService spuInfoService;


    @RequestMapping("/{skuId}.html")
    public String getSkuInfo(@PathVariable("skuId") String skuId,Model model){

        SkuInfo skuInfo = skuInfoService.getSkuInfo(skuId);
        model.addAttribute("skuInfo",skuInfo);

        List<SpuSaleAttr> spuSaleAttrListCheckBySku = spuInfoService.getSpuSaleAttrListCheckBySku(skuId, skuInfo.getSpuId());

        model.addAttribute("spuSaleAttrListCheckBySku",spuSaleAttrListCheckBySku);

        List<SkuInfo> skuInfos = skuInfoService.getSkuSaleAttrValueListBySpu(skuInfo.getSpuId());


        Map<String,String> valuesSkuMap=new HashMap<>();


        for (SkuInfo info : skuInfos) {

            String valueIdsKey="";

            String val = info.getId();

            List<SkuSaleAttrValue> skuSaleAttrValueList = info.getSkuSaleAttrValueList();

            if(CollectionUtils.isNotEmpty(skuSaleAttrValueList)){
                int i = 0;
                for (SkuSaleAttrValue skuSaleAttrValue : skuSaleAttrValueList) {
                    if(i == 0){
                        valueIdsKey += skuSaleAttrValue.getSaleAttrValueId();
                    }else{
                        valueIdsKey += "|" + skuSaleAttrValue.getSaleAttrValueId();
                    }
                    i++;
                }
            }
            valuesSkuMap.put(valueIdsKey,val);
        }


        //把map变成json串
        String valuesSkuJson = JSON.toJSONString(valuesSkuMap);

        System.out.println(valuesSkuMap.toString());

        model.addAttribute("valuesSkuJson",valuesSkuJson);

        return "item";
    }


}
