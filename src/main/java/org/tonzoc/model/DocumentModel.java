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
    @Column(value = "title")
    private String title; // 标题
    @Column(value = "startTime")
    private Date startTime; // 创建日期
    @Column(value = "endTime")
    private Date endTime; // 结束时间
    private String startDate;
    private String endDate;
    @Column(value = "createPersonGuid")
    private String createPersonGuid; // 创建人
    @Column(value = "status")
    private String status; // 状态
    @Column(value = "sortId")
    private Integer sortId;

    @JoinColumn(value = "name", type = PersonModel.class, leftColumn = "createPersonGuid", rightColumn = "guid")
    private String personName;  // 人员名称

    public DocumentModel() {
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "DocumentModel{" +
                "guid='" + guid + '\'' +
                ", title='" + title + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", createPersonGuid='" + createPersonGuid + '\'' +
                ", status='" + status + '\'' +
                ", sortId=" + sortId +
                ", personName='" + personName + '\'' +
                '}';
    }
}
