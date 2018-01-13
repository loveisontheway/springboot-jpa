package com.liotw.springboot.jpa.repository;

import com.liotw.springboot.jpa.domain.MdAdministrativeRegion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 行政区划-Repository接口类
 * @author jiangjialiang on 2017/12/20
 * @version 3.0.0
 */
@Repository
public interface MdAdministrativeRegionRepository extends JpaRepository<MdAdministrativeRegion, Integer> {

    /**
     * 根据条件查询行政区划列表
     * @param id 主键
     * @return List<MdAdministrativeRegion> 行政区划对象集合
     */
    List<MdAdministrativeRegion> findMdAdministrativeRegionById(Integer id);
}
