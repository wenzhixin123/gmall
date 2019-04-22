package com.xinxin.gmall.manage.mapper;

import com.xinxin.gmall.bean.SkuInfo;
import com.xinxin.gmall.bean.SkuSaleAttrValue;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SkuSaleAttrValueMapper extends Mapper<SkuSaleAttrValue> {

    List<SkuInfo> selectSkuSaleAttrValueListBySpu(@Param("spuId") long spuId);
}
