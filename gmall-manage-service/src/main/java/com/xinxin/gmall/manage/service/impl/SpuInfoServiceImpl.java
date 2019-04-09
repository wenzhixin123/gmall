package com.xinxin.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xinxin.gmall.bean.SpuInfo;
import com.xinxin.gmall.manage.mapper.SpuInfoMapper;
import com.xinxin.gmall.service.SpuInfoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class SpuInfoServiceImpl implements SpuInfoService {

    @Autowired
    SpuInfoMapper spuInfoMapper;

    @Override
    public List<SpuInfo> spuInfoList(String catalog3Id) {

        SpuInfo spuInfo = new SpuInfo();
        spuInfo.setCatalog3Id(catalog3Id);

        List<SpuInfo> infos = spuInfoMapper.select(spuInfo);

        return infos;
    }
}
