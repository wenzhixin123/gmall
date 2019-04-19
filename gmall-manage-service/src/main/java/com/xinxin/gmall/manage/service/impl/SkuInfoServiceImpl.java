package com.xinxin.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xinxin.gmall.bean.SkuAttrValue;
import com.xinxin.gmall.bean.SkuImage;
import com.xinxin.gmall.bean.SkuInfo;
import com.xinxin.gmall.bean.SkuSaleAttrValue;
import com.xinxin.gmall.manage.mapper.SkuAttrValueMapper;
import com.xinxin.gmall.manage.mapper.SkuImageMapper;
import com.xinxin.gmall.manage.mapper.SkuInfoMapper;
import com.xinxin.gmall.manage.mapper.SkuSaleAttrValueMapper;
import com.xinxin.gmall.service.SkuInfoService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class SkuInfoServiceImpl implements SkuInfoService {

    @Autowired
    SkuInfoMapper skuInfoMapper;

    @Autowired
    SkuImageMapper skuImageMapper;

    @Autowired
    SkuAttrValueMapper skuAttrValueMapper;

    @Autowired
    SkuSaleAttrValueMapper skuSaleAttrValueMapper;


    @Override
    public List<SkuInfo> skuInfoListBySpu(String spuId) {

        SkuInfo skuInfo = new SkuInfo();
        skuInfo.setSpuId(spuId);

        List<SkuInfo> skuInfos = skuInfoMapper.select(skuInfo);

        return skuInfos;
    }

    @Override
    public boolean saveSku(SkuInfo skuInfo) {

        //保存SKU
        skuInfoMapper.insertSelective(skuInfo);

        //图片
        List<SkuImage> skuImageList = skuInfo.getSkuImageList();
        if(CollectionUtils.isNotEmpty(skuImageList)){
            skuImageList.forEach((e)->{
                e.setSkuId(skuInfo.getId());
                skuImageMapper.insert(e);
            });
        }

        //平台属性
        List<SkuAttrValue> skuAttrValues = skuInfo.getSkuAttrValueList();
        if(CollectionUtils.isNotEmpty(skuAttrValues)){
            skuAttrValues.forEach((e)->{
                e.setSkuId(skuInfo.getId());
                skuAttrValueMapper.insert(e);
            });
        }

        //销售属性
        List<SkuSaleAttrValue> skuSaleAttrValues = skuInfo.getSkuSaleAttrValueList();
        if(CollectionUtils.isNotEmpty(skuSaleAttrValues)){
            skuSaleAttrValues.forEach((e)->{
                e.setSkuId(skuInfo.getId());
                skuSaleAttrValueMapper.insert(e);
            });
        }

        return true;
    }
}
