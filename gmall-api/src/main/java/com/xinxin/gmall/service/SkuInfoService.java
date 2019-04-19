package com.xinxin.gmall.service;

import com.xinxin.gmall.bean.SkuInfo;

import java.util.List;

public interface SkuInfoService {
    List<SkuInfo> skuInfoListBySpu(String spuId);

    boolean saveSku(SkuInfo skuInfo);
}
