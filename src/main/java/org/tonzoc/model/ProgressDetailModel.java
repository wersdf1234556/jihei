package org.tonzoc.model;

import org.apache.commons.lang.StringUtils;
import org.tonzoc.annotation.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.Collectors;

@Table(value = "progressDetails")
public class ProgressDetailModel extends BaseModel{
    @PrimaryKey
    @NotInsertColumn
    @Column(value = "guid")
    private String guid;
    @Column(value = "progressNameGuid")
    private String progressNameGuid;
    @Column(value = "tenderGuid")
    private String tenderGuid;
    @Column(value = "date")
    private String date;
    @Column(value = "num")
    private BigDecimal num;
    @JoinColumn(value = "name", type = ProgressNameModel.class, leftColumn = "progressNameGuid", rightColumn = "guid")
    private String progressName; //进度名称
    @JoinColumn(value = "name", type = TenderModel.class, leftColumn = "tenderGuid", rightColumn = "guid")
    private String tenderName; //标段
    @Column(value = "status")
    private String status; //审批状态
    @Column(value = "currentTenderGuid")
    private String currentTenderGuid; //当前审批标段guid
    @JoinColumn(value = "name", type = TenderModel.class, leftColumn = "currentTenderGuid", rightColumn = "guid")
    private String currentTenderName; //当前审批标段name
    @Column(value = "approvalTime")
    private String approvalTime; //审批时间

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BigDecimal getNum() {
        return num;
    }

    public void setNum(BigDecimal num) {
        this.num = num;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCurrentTenderGuid() {
        return currentTenderGuid;
    }

    public void setCurrentTenderGuid(String currentTenderGuid) {
        this.currentTenderGuid = currentTenderGuid;
    }

    public String getCurrentTenderName() {
        return currentTenderName;
    }

    public void setCurrentTenderName(String currentTenderName) {
        this.currentTenderName = currentTenderName;
    }

    public String getApprovalTime() {
        return approvalTime;
    }

    public void setApprovalTime(String approvalTime) {
        this.approvalTime = approvalTime;
    }

    @Override
    public String toString() {
        return "ProgressDetailModel{" +
                "guid='" + guid + '\'' +
                ", progressNameGuid='" + progressNameGuid + '\'' +
                ", tenderGuid='" + tenderGuid + '\'' +
                ", date='" + date + '\'' +
                ", num=" + num +
                ", progressName='" + progressName + '\'' +
                ", tenderName='" + tenderName + '\'' +
                ", status='" + status + '\'' +
                ", currentTenderGuid='" + currentTenderGuid + '\'' +
                ", currentTenderName='" + currentTenderName + '\'' +
                ", approvalTime='" + approvalTime + '\'' +
                '}';
    }
}
