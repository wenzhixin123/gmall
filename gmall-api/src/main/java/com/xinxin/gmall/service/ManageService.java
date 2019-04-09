package com.xinxin.gmall.service;

import com.xinxin.gmall.bean.BaseAttrInfo;
import com.xinxin.gmall.bean.BaseCatalog1;
import com.xinxin.gmall.bean.BaseCatalog2;
import com.xinxin.gmall.bean.BaseCatalog3;

import java.util.List;

public interface ManageService {
    public List<BaseCatalog1> getCatalog1();

    public List<BaseCatalog2> getCatalog2(String catalog1Id);

    public List<BaseCatalog3> getCatalog3(String catalog2Id);

    public List<BaseAttrInfo> getAttrList(String catalog3Id);

    public BaseAttrInfo getAttrInfo(String attrId);

    boolean saveAttrInfo(BaseAttrInfo baseAttrInfo);
}
