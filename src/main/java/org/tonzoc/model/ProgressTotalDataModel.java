package org.tonzoc.model;

import org.tonzoc.annotation.*;

import java.math.BigDecimal;

@Table(value = "progressTotalDatas")
public class ProgressTotalDataModel extends BaseModel{
    @PrimaryKey
    @NotInsertColumn
    @Column(value = "guid")
    private String guid;
    @Column(value = "progressNameGuid")
    private String progressNameGuid;
    @Column(value = "tenderGuid")
    private String tenderGuid;
    @Column(value = "totalNum")
    private BigDecimal totalNum;
    @JoinColumn(value = "name", type = ProgressNameModel.class, leftColumn = "progressNameGuid", rightColumn = "guid")
    private String progressName; //进度名称
    @JoinColumn(value = "name", type = TenderModel.class, leftColumn = "tenderGuid", rightColumn = "guid")
    private String tenderName; //标段
    @Column(value = "flag")
    private Integer flag;//0：总计划    1：年计划   2：月计划

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getProgressNameGuid() {
        return progressNameGuid;
    }

    public void setProgressNameGuid(String progressNameGuid) {
        this.progressNameGuid = progressNameGuid;
    }

    public String getTenderGuid() {
        return tenderGuid;
    }

    public void setTenderGuid(String tenderGuid) {
        this.tenderGuid = tenderGuid;
    }

    public BigDecimal getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(BigDecimal totalNum) {
        this.totalNum = totalNum;
    }

    public String getProgressName() {
        return progressName;
    }

    public void setProgressName(String progressName) {
        this.progressName = progressName;
    }

    public String getTenderName() {
        return tenderName;
    }

    public void setTenderName(String tenderName) {
        this.tenderName = tenderName;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "ProgressTotalDataModel{" +
                "guid='" + guid + '\'' +
                ", progressNameGuid='" + progressNameGuid + '\'' +
                ", tenderGuid='" + tenderGuid + '\'' +
                ", totalNum=" + totalNum +
                ", progressName='" + progressName + '\'' +
                ", tenderName='" + tenderName + '\'' +
                ", flag=" + flag +
                '}';
    }
}
