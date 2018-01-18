package com.liotw.springboot.jpa.service.impl;

import com.liotw.springboot.jpa.core.TreeNode;
import com.liotw.springboot.jpa.domain.MdAdministrativeRegion;
import com.liotw.springboot.jpa.repository.MdAdministrativeRegionRepository;
import com.liotw.springboot.jpa.service.MdAdministrativeRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * 行政区划-Service接口实现类（业务处理层）
 * @author jiangjialiang on 2017/12/20
 * @version 1.0.0
 */
@Service
public class MdAdministrativeRegionServiceImpl implements MdAdministrativeRegionService {

    @Autowired
    private MdAdministrativeRegionRepository mdAdministrativeRegionRepository;

    /**
     * 根据条件查询行政区划列表
     * @param params HashMap参数
     * @return List<MdAdministrativeRegion> 行政区划对象集合
     */
    @Override
    public List<MdAdministrativeRegion> findMdAdministrativeRegion(HashMap<String, Object> params) {
        Integer id = (Integer) params.get("id");
        return mdAdministrativeRegionRepository.findMdAdministrativeRegionById(id);
    }

    /**
     * 删除
     * @param params HashMap参数
     */
    @Override
    public void delete(HashMap<String, Object> params) {
        Integer id = (Integer) params.get("id");
        mdAdministrativeRegionRepository.delete(id);
    }

    @Override
    public List<TreeNode> tree(List<String> idList) {
        return null;
    }
}
