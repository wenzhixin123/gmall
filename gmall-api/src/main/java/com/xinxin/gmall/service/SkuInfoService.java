package com.xinxin.gmall.service;

import com.xinxin.gmall.bean.SkuInfo;
import com.xinxin.gmall.bean.SkuSaleAttrValue;
import com.xinxin.gmall.bean.SpuSaleAttr;

import java.util.List;

public interface SkuInfoService {
    List<SkuInfo> skuInfoListBySpu(String spuId);

    boolean saveSku(SkuInfo skuInfo);

    SkuInfo getSkuInfo(String skuId);

    List<SkuInfo> getSkuSaleAttrValueListBySpu(String spuId);
}
