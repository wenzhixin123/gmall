package com.xinxin.gmall.service;

import com.xinxin.gmall.bean.*;

import java.util.List;

public interface SpuInfoService {

    List<SpuInfo> spuInfoList(String catalog3Id);

    List<BaseSaleAttr> getBaseSaleAttr();

    boolean saveSpu(SpuInfo spuInfo);

    List<SpuImage> spuImageList(String spuId);

    List<SpuSaleAttr> spuSaleAttrList(String spuId);

    List<BaseAttrInfo> attrInfoList(String catalog3Id);
}
