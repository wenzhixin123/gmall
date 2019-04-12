package com.xinxin.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xinxin.gmall.bean.*;
import com.xinxin.gmall.manage.mapper.*;
import com.xinxin.gmall.service.SpuInfoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class SpuInfoServiceImpl implements SpuInfoService {

    @Autowired
    SpuInfoMapper spuInfoMapper;

    @Autowired
    SpuSaleAttrMapper spuSaleAttrMapper;

    @Autowired
    SpuImageMapper spuImageMapper;

    @Autowired
    SpuSaleAttrValueMapper spuSaleAttrValueMapper;


    @Autowired
    BaseSaleAttrMapper baseSaleAttrMapper;


    @Override
    public List<SpuInfo> spuInfoList(String catalog3Id) {

        SpuInfo spuInfo = new SpuInfo();
        spuInfo.setCatalog3Id(catalog3Id);

        List<SpuInfo> infos = spuInfoMapper.select(spuInfo);

        return infos;
    }

    @Override
    public List<BaseSaleAttr> getBaseSaleAttr() {
        return baseSaleAttrMapper.selectAll();
    }

    @Override
    public boolean saveSpu(SpuInfo spuInfo) {

        spuInfoMapper.insertSelective(spuInfo);//保存并更新主键

        //保存图片
        List<SpuImage> spuImageList = spuInfo.getSpuImageList();
        for (SpuImage spuImage : spuImageList) {
            spuImage.setSpuId(spuInfo.getId());
            spuImageMapper.insert(spuImage);
        }


        //保存销售属性
        List<SpuSaleAttr> spuSaleAttrList = spuInfo.getSpuSaleAttrList();
        for (SpuSaleAttr spuSaleAttr : spuSaleAttrList) {

            spuSaleAttr.setSpuId(spuInfo.getId());
            List<SpuSaleAttrValue> spuSaleAttrValueList = spuSaleAttr.getSpuSaleAttrValueList();

            spuSaleAttrMapper.insert(spuSaleAttr);

            for (SpuSaleAttrValue spuSaleAttrValue : spuSaleAttrValueList) {
                spuSaleAttrValue.setSpuId(spuInfo.getId());
                spuSaleAttrValueMapper.insert(spuSaleAttrValue);
            }

        }

        return true;
    }
}
