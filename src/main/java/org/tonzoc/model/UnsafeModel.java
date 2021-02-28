package org.tonzoc.model;

import org.tonzoc.annotation.*;

// 安全隐患表
@Table("unsafes")
public class UnsafeModel extends BaseModel {

    @NotInsertColumn
    @PrimaryKey
    @Column(value = "guid")
    private String guid;
    @Column(value = "grade")
    private String grade; // 安全隐患等级
    @Column(value = "parts")
    private String parts; // 部位
    @Column(value = "tenderGuid")
    private String tenderGuid;
    @Column(value = "sortId")
    private String sortId;

    @JoinColumn(value = "name", type = TenderModel.class, leftColumn = "tenderGuid", rightColumn = "guid")
    private String tenderName;  // 标段单位名称

    public UnsafeModel() {
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getParts() {
        return parts;
    }

    public void setParts(String parts) {
        this.parts = parts;
    }

    public String getTenderGuid() {
        return tenderGuid;
    }

    public void setTenderGuid(String tenderGuid) {
        this.tenderGuid = tenderGuid;
    }

    public String getTenderName() {
        return tenderName;
    }

    public void setTenderName(String tenderName) {
        this.tenderName = tenderName;
    }

    public String getSortId() {
        return sortId;
    }

    public void setSortId(String sortId) {
        this.sortId = sortId;
    }

    @Override
    public String toString() {
        return "UnsafeModel{" +
                "guid='" + guid + '\'' +
                ", grade='" + grade + '\'' +
                ", parts='" + parts + '\'' +
                ", tenderGuid='" + tenderGuid + '\'' +
                ", sortId='" + sortId + '\'' +
                ", tenderName='" + tenderName + '\'' +
                '}';
    }
}
