package com.framelib.dubbo.neworder.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.framelib.dubbo.model.BaseModel;

public class NewGoodsServiceItem extends BaseModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -40519156189040160L;
    /**服务项主键id*/
    private String id;

    /**服务项code*/
    private String code;

    /**服务项名称*/
    private String name;

    /**简介*/
    private String info;

    /**分类标签*/
    private String tags;

    /**区域*/
    private String areaId;

    /**送检机构*/
    private Integer examineOrg;

    /**解读医生需求*/
    private Integer doctorDeptId;

    /**可售卖医生组*/
    private Integer doctorGroupId;

    /**基础价格*/
    private BigDecimal price;

    /**解读价格*/
    private BigDecimal decodePrice;

    /**售卖状态*/
    private Byte sellState;

    /**履约状态*/
    private Byte arrangeState;

    /**操作人1*/
    private Integer operator1;

    /**操作人2*/
    private Integer operator2;

    /**服务时长（分）*/
    private Integer serviceTime;

    /**特殊说明*/
    private String specialExplain;

    /**创建者*/
    private String creator;

    /**更新者*/
    private String updater;

    /**创建时间*/
    private Date createTime;

    /**更新时间*/
    private Date updateTime;

    /***/
    private Integer ext1Int;

    /***/
    private Integer ext2Int;

    /***/
    private Integer ext3Int;

    /***/
    private String ext1Txt;

    /***/
    private String ext2Txt;

    /***/
    private String ext3Txt;

    /***/
    private BigDecimal ext1Price;

    /***/
    private BigDecimal ext2Price;

    /***/
    private Date ext1Time;

    /***/
    private Date ext2Time;

    private String merchantId;


    private String sampleType;

    /**
     * 样本类型
     */
    public enum SERVICE_ITEM_SAMPLE_TYPE{

        XQ("血清"),
        XQOGXP("血清/干血片"),
        GXP("干血片"),
        KNX("EDTA抗凝血"),
        MSQXOJMX("末梢全血/静脉血（绿管）"),
        LCZZLCRMYCQX("流产组织/流产绒毛/引产脐血"),
        HQD("呼气袋"),
        MSQXKNX("末梢全血/EDTA抗凝血"),
        MSQX("末梢全血"),
        SZ("拭子"),
        ZDN("中段尿"),
        ;

        private String name;

        SERVICE_ITEM_SAMPLE_TYPE(String name) {
            this.name = name;
        }
        public static List<String> allType(){
            List<String> allType = new ArrayList<>();
            SERVICE_ITEM_SAMPLE_TYPE[] values = SERVICE_ITEM_SAMPLE_TYPE.values();
            for (SERVICE_ITEM_SAMPLE_TYPE value: values){
                allType.add(value.name);
            }
            return allType;
        }
    }

    public String getSampleType() {
        return sampleType;
    }

    public void setSampleType(String sampleType) {
        this.sampleType = sampleType;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    /**服务项主键id*/
    public String getId() {
        return id;
    }

    /**服务项主键id*/
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**服务项code*/
    public String getCode() {
        return code;
    }

    /**服务项code*/
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**服务项名称*/
    public String getName() {
        return name;
    }

    /**服务项名称*/
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**简介*/
    public String getInfo() {
        return info;
    }

    /**简介*/
    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    /**分类标签*/
    public String getTags() {
        return tags;
    }

    /**分类标签*/
    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
    }

    /**区域*/
    public String getAreaId() {
        return areaId;
    }

    /**区域*/
    public void setAreaId(String areaId) {
        this.areaId = areaId == null ? null : areaId.trim();
    }

    /**送检机构*/
    public Integer getExamineOrg() {
        return examineOrg;
    }

    /**送检机构*/
    public void setExamineOrg(Integer examineOrg) {
        this.examineOrg = examineOrg;
    }

    /**解读医生需求*/
    public Integer getDoctorDeptId() {
        return doctorDeptId;
    }

    /**解读医生需求*/
    public void setDoctorDeptId(Integer doctorDeptId) {
        this.doctorDeptId = doctorDeptId;
    }

    /**可售卖医生组*/
    public Integer getDoctorGroupId() {
        return doctorGroupId;
    }

    /**可售卖医生组*/
    public void setDoctorGroupId(Integer doctorGroupId) {
        this.doctorGroupId = doctorGroupId;
    }

    /**基础价格*/
    public BigDecimal getPrice() {
        return price;
    }

    /**基础价格*/
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**解读价格*/
    public BigDecimal getDecodePrice() {
        return decodePrice;
    }

    /**解读价格*/
    public void setDecodePrice(BigDecimal decodePrice) {
        this.decodePrice = decodePrice;
    }

    /**售卖状态*/
    public Byte getSellState() {
        return sellState;
    }

    /**售卖状态*/
    public void setSellState(Byte sellState) {
        this.sellState = sellState;
    }

    /**履约状态*/
    public Byte getArrangeState() {
        return arrangeState;
    }

    /**履约状态*/
    public void setArrangeState(Byte arrangeState) {
        this.arrangeState = arrangeState;
    }

    /**操作人1*/
    public Integer getOperator1() {
        return operator1;
    }

    /**操作人1*/
    public void setOperator1(Integer operator1) {
        this.operator1 = operator1;
    }

    /**操作人2*/
    public Integer getOperator2() {
        return operator2;
    }

    /**操作人2*/
    public void setOperator2(Integer operator2) {
        this.operator2 = operator2;
    }

    /**服务时长（分）*/
    public Integer getServiceTime() {
        return serviceTime;
    }

    /**服务时长（分）*/
    public void setServiceTime(Integer serviceTime) {
        this.serviceTime = serviceTime;
    }

    /**特殊说明*/
    public String getSpecialExplain() {
        return specialExplain;
    }

    /**特殊说明*/
    public void setSpecialExplain(String specialExplain) {
        this.specialExplain = specialExplain == null ? null : specialExplain.trim();
    }

    /**创建者*/
    public String getCreator() {
        return creator;
    }

    /**创建者*/
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**更新者*/
    public String getUpdater() {
        return updater;
    }

    /**更新者*/
    public void setUpdater(String updater) {
        this.updater = updater == null ? null : updater.trim();
    }

    /**创建时间*/
    public Date getCreateTime() {
        return createTime;
    }

    /**创建时间*/
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**更新时间*/
    public Date getUpdateTime() {
        return updateTime;
    }

    /**更新时间*/
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /***/
    public Integer getExt1Int() {
        return ext1Int;
    }

    /***/
    public void setExt1Int(Integer ext1Int) {
        this.ext1Int = ext1Int;
    }

    /***/
    public Integer getExt2Int() {
        return ext2Int;
    }

    /***/
    public void setExt2Int(Integer ext2Int) {
        this.ext2Int = ext2Int;
    }

    /***/
    public Integer getExt3Int() {
        return ext3Int;
    }

    /***/
    public void setExt3Int(Integer ext3Int) {
        this.ext3Int = ext3Int;
    }

    /***/
    public String getExt1Txt() {
        return ext1Txt;
    }

    /***/
    public void setExt1Txt(String ext1Txt) {
        this.ext1Txt = ext1Txt == null ? null : ext1Txt.trim();
    }

    /***/
    public String getExt2Txt() {
        return ext2Txt;
    }

    /***/
    public void setExt2Txt(String ext2Txt) {
        this.ext2Txt = ext2Txt == null ? null : ext2Txt.trim();
    }

    /***/
    public String getExt3Txt() {
        return ext3Txt;
    }

    /***/
    public void setExt3Txt(String ext3Txt) {
        this.ext3Txt = ext3Txt == null ? null : ext3Txt.trim();
    }

    /***/
    public BigDecimal getExt1Price() {
        return ext1Price;
    }

    /***/
    public void setExt1Price(BigDecimal ext1Price) {
        this.ext1Price = ext1Price;
    }

    /***/
    public BigDecimal getExt2Price() {
        return ext2Price;
    }

    /***/
    public void setExt2Price(BigDecimal ext2Price) {
        this.ext2Price = ext2Price;
    }

    /***/
    public Date getExt1Time() {
        return ext1Time;
    }

    /***/
    public void setExt1Time(Date ext1Time) {
        this.ext1Time = ext1Time;
    }

    /***/
    public Date getExt2Time() {
        return ext2Time;
    }

    /***/
    public void setExt2Time(Date ext2Time) {
        this.ext2Time = ext2Time;
    }
}