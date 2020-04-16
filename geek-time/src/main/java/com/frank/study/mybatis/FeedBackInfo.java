package com.frank.study.mybatis;

import java.util.Date;

/**
 * @author 孙中伟)
 * @title: FeedBackInfo
 * @description: TODO
 * @date 2019/12/19 10:22
 */
public class FeedBackInfo{

    protected Long id;

    protected Date createTime;

    protected Date updateTime;

    protected Integer isDeleted;

    /**
     * 工单ID
     */
    private Long workOrderId;

    /**
     * 是否及时验收
     */
    private Integer checkAndAccept;

    /**
     * 满意度
     */
    private Integer satisfaction;

    /**
     * 备注
     */
    private String remark;

    /**
     * 打分原因（高于8分和低于5分需要填写）
     */
    private String remarkForSatisfaction;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Long getWorkOrderId() {
        return workOrderId;
    }

    public void setWorkOrderId(Long workOrderId) {
        this.workOrderId = workOrderId;
    }

    public Integer getCheckAndAccept() {
        return checkAndAccept;
    }

    public void setCheckAndAccept(Integer checkAndAccept) {
        this.checkAndAccept = checkAndAccept;
    }

    public Integer getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(Integer satisfaction) {
        this.satisfaction = satisfaction;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemarkForSatisfaction() {
        return remarkForSatisfaction;
    }

    public void setRemarkForSatisfaction(String remarkForSatisfaction) {
        this.remarkForSatisfaction = remarkForSatisfaction;
    }
}
