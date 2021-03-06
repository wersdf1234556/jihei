package org.tonzoc.model;

import org.tonzoc.annotation.*;

import java.util.Date;


// 大事记
@Table("memorabilias")
public class MemorabiliaModel extends BaseModel {

    @NotInsertColumn
    @PrimaryKey
    @Column(value = "guid")
    private String guid;
    @Column(value = "name")
    private String name;
    @Column(value = "currentTime")
    private Date currentTime;
    private String currentDate;
    @Column(value = "sortId")
    private Integer sortId;
    @Column(value = "imgAttachmentGuid")
    private String imgAttachmentGuid;
    @Column(value = "pdfAttachmentGuid")
    private String pdfAttachmentGuid;

    @JoinColumn(value = "name", type = AttachmentModel.class, leftColumn = "imgAttachmentGuid", rightColumn = "guid")
    private String imgName;  // 图片名称
    @JoinColumn(value = "name", type = AttachmentModel.class, leftColumn = "pdfAttachmentGuid", rightColumn = "guid")
    private String pdfName;  // pdf名称


    public MemorabiliaModel() {
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Date currentTime) {
        this.currentTime = currentTime;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public String getImgAttachmentGuid() {
        return imgAttachmentGuid;
    }

    public void setImgAttachmentGuid(String imgAttachmentGuid) {
        this.imgAttachmentGuid = imgAttachmentGuid;
    }

    public String getPdfAttachmentGuid() {
        return pdfAttachmentGuid;
    }

    public void setPdfAttachmentGuid(String pdfAttachmentGuid) {
        this.pdfAttachmentGuid = pdfAttachmentGuid;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getPdfName() {
        return pdfName;
    }

    public void setPdfName(String pdfName) {
        this.pdfName = pdfName;
    }

    @Override
    public String toString() {
        return "MemorabiliaModel{" +
                "guid='" + guid + '\'' +
                ", name='" + name + '\'' +
                ", currentTime=" + currentTime +
                ", currentDate='" + currentDate + '\'' +
                ", sortId=" + sortId +
                ", imgAttachmentGuid='" + imgAttachmentGuid + '\'' +
                ", pdfAttachmentGuid='" + pdfAttachmentGuid + '\'' +
                ", imgName='" + imgName + '\'' +
                ", pdfName='" + pdfName + '\'' +
                '}';
    }
}
