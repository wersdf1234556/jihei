package org.tonzoc.model;

import org.tonzoc.annotation.*;

import java.util.Date;

// 安全流程表
@Table("documents")
public class DocumentModel extends BaseModel{

    @NotInsertColumn
    @PrimaryKey
    @Column(value = "guid")
    private String guid;
    @Column(value = "createDate")
    private Date createDate; // 创建日期
    @Column(value = "tenderGuid")
    private String tenderGuid;
    @Column(value = "currentStepGuid")
    private String currentStepGuid; // 当前步骤
    @Column(value = "createPersonGuid")
    private String createPersonGuid; // 创建人
    @Column(value = "status")
    private String status;

    @JoinColumn(value = "name", type = TenderModel.class, leftColumn = "tenderGuid", rightColumn = "guid")
    private String tenderName;  // 标段名称
    @JoinColumn(value = "name", type = PersonModel.class, leftColumn = "currentStepGuid", rightColumn = "guid")
    private String personName;  // 标段名称
    @JoinColumn(value = "name", type = StepModel.class, leftColumn = "currentStepGuid", rightColumn = "guid")
    private String stepName;  // 标段名称

    public DocumentModel() {
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getTenderGuid() {
        return tenderGuid;
    }

    public void setTenderGuid(String tenderGuid) {
        this.tenderGuid = tenderGuid;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCurrentStepGuid() {
        return currentStepGuid;
    }

    public void setCurrentStepGuid(String currentStepGuid) {
        this.currentStepGuid = currentStepGuid;
    }

    public String getCreatePersonGuid() {
        return createPersonGuid;
    }

    public void setCreatePersonGuid(String createPersonGuid) {
        this.createPersonGuid = createPersonGuid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTenderName() {
        return tenderName;
    }

    public void setTenderName(String tenderName) {
        this.tenderName = tenderName;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getStepName() {
        return stepName;
    }

    public void setStepName(String stepName) {
        this.stepName = stepName;
    }
}
