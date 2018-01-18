package com.liotw.springboot.jpa.service;

import com.liotw.springboot.jpa.core.TreeNode;
import com.liotw.springboot.jpa.domain.MdAdministrativeRegion;

import java.util.HashMap;
import java.util.List;

/**
 * 行政区划-Service接口类
 * @author jiangjialiang on 2017/12/20
 * @version 1.0.0
 */
public interface MdAdministrativeRegionService {

    /**
     * 根据条件查询行政区划列表
     * @param params HashMap参数
     * @return List<MdAdministrativeRegion> 行政区划对象集合
     */
    List<MdAdministrativeRegion> findMdAdministrativeRegion(HashMap<String, Object> params);

    /**
     * 删除
     * @param params HashMap参数
     */
    void delete(HashMap<String, Object> params);

    /**
     * 根据角色获取权限树，返回的是所有菜单
     * @param idList
     * @return
     */
    List<TreeNode> tree(List<String> idList);
}
