package com.liotw.springboot.jpa.domain;


import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 行政区划代码-实体类
 * @author jiangjialiang on 2017/12/20
 * @version 1.0.0
 */
@Entity
@Table(appliesTo = "md_administrative_region", comment = "行政区划代码表")
public class MdAdministrativeRegion implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(columnDefinition = "varchar(30) comment '行版本，记录数据版本号'")
    private String rowVersion;

    @Column(nullable = false, columnDefinition = "varchar(128) comment '行政区划名称'")
    private String areaName;

    @Column(nullable = false, columnDefinition = "bigint(12) comment '行政区划编码'")
    private Long areaCode;

    @Column(nullable = false, columnDefinition = "double(20,12) comment '经度'")
    private Double longitude;

    @Column(nullable = false, columnDefinition = "double(20,12) comment '纬度'")
    private Double latitude;

    @Column(columnDefinition = "bigint(12) comment '父级行政区划编码'")
    private String parentCode;

    @Column(columnDefinition = "varchar(100) comment '第三方行政区划编码'")
    private String otherCode;

    @Column(nullable = false, columnDefinition = "bigint(12) comment '省（自治区、直辖市、特别行政区）代码'")
    private Long provinceId;

    @Column(columnDefinition = "bigint(12) comment '市（地区、自治州、盟）代码'")
    private Long cityId;

    @Column(columnDefinition = "bigint(12) comment '县（市辖区、县级市、旗）代码'")
    private Long countyId;

    @Column(columnDefinition = "bigint(12) comment '乡、镇（街道办事处）代码'")
    private Long townId;

    @Column(columnDefinition = "bigint(12) comment '村（居民委员会、村民委员会）代码'")
    private Long villageId;

    @Column(nullable = false, columnDefinition = "int(1) comment '等级（省1、市2、县3、镇4、村5）'")
    private Integer grade;

    @Column(nullable = false, columnDefinition = "varchar(128) comment '省（自治区、直辖市、特别行政区）名称'")
    private String provinceName;

    @Column(columnDefinition = "varchar(128) comment '市（地区、自治州、盟）名称'")
    private String cityName;

    @Column(columnDefinition = "varchar(128) comment '县（市辖区、县级市、旗）名称'")
    private String countyName;

    @Column(columnDefinition = "varchar(128) comment '乡、镇（街道办事处）名称'")
    private String townName;

    @Column(columnDefinition = "varchar(128) comment '村（居民委员会、村民委员会）名称'")
    private String villageName;

    @Column(nullable = false, columnDefinition = "varchar(256) comment '行政区划全称'")
    private String fullName;

    @Column(columnDefinition = "int(3) comment '城乡分类代码'")
    private Integer category;

    @Column(columnDefinition = "varchar(200) comment '行政区划原名称'")
    private String nativeName;

    @Column(columnDefinition = "varchar(200) comment '行政区划原代码'")
    private String nativeCode;

    @Column(columnDefinition = "varchar(300) comment '行政区域变更原因'")
    private String changeReason;

    @Column(columnDefinition = "int(5) default 0 comment '排序方式'")
    private Integer sortOrder;

    @Column(nullable = false, columnDefinition = "int(1) default 0 comment '状态值（0启用、1停用）'")
    private Integer state;

    @Column(columnDefinition = "varchar(500) comment '备注'")
    private String remark;

    @Column(nullable = false, columnDefinition = "varchar(32) comment '创建者id'")
    private String createId;

    @Column(nullable = false, columnDefinition = "datetime comment '创建时间'")
    private Date createTime;

    @Column(columnDefinition = "varchar(32) comment '修改者id'")
    private String modifyId;

    @Column(columnDefinition = "datetime comment '修改时间'")
    private Date modifyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRowVersion() {
        return rowVersion;
    }

    public void setRowVersion(String rowVersion) {
        this.rowVersion = rowVersion;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Long getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(Long areaCode) {
        this.areaCode = areaCode;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getOtherCode() {
        return otherCode;
    }

    public void setOtherCode(String otherCode) {
        this.otherCode = otherCode;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getCountyId() {
        return countyId;
    }

    public void setCountyId(Long countyId) {
        this.countyId = countyId;
    }

    public Long getTownId() {
        return townId;
    }

    public void setTownId(Long townId) {
        this.townId = townId;
    }

    public Long getVillageId() {
        return villageId;
    }

    public void setVillageId(Long villageId) {
        this.villageId = villageId;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getNativeName() {
        return nativeName;
    }

    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }

    public String getNativeCode() {
        return nativeCode;
    }

    public void setNativeCode(String nativeCode) {
        this.nativeCode = nativeCode;
    }

    public String getChangeReason() {
        return changeReason;
    }

    public void setChangeReason(String changeReason) {
        this.changeReason = changeReason;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifyId() {
        return modifyId;
    }

    public void setModifyId(String modifyId) {
        this.modifyId = modifyId;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}
