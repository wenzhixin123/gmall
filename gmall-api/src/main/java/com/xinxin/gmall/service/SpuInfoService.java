package com.xinxin.gmall.service;

import com.xinxin.gmall.bean.BaseSaleAttr;
import com.xinxin.gmall.bean.SpuInfo;

import java.util.List;

public interface SpuInfoService {

    List<SpuInfo> spuInfoList(String catalog3Id);

    List<BaseSaleAttr> getBaseSaleAttr();
}
