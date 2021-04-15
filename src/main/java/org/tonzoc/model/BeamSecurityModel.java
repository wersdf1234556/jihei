package org.tonzoc.model;

import org.tonzoc.annotation.*;

// 安全梁场
@Table("beamSecuritys")
public class BeamSecurityModel extends BaseModel{

    @PrimaryKey
    @NotInsertColumn
    @Column(value = "guid")
    private String guid;
    @Column(value = "tenderGuid")
    private String tenderGuid;
    @Column(value = "position")
    private String position; // 位置
    @Column(value = "type")
    private String type; // 类型
    @Column(value = "number")
    private Integer number; // 人数
    @Column(value = "dates")
    private String dates; // 日期
    @Column(value = "attImgGuid")
    private String attImgGuid;
    @Column(value = "sortId")
    private Integer sortId;

    @JoinColumn(value = "name", type = TenderModel.class, leftColumn = "tenderGuid", rightColumn = "guid")
    private String tenderName;
    @JoinColumn(value = "name", type = AttachmentModel.class, leftColumn = "attImgGuid", rightColumn = "guid")
    private String attImgName;
    @JoinColumn(value = "url", type = AttachmentModel.class, leftColumn = "attImgGuid", rightColumn = "guid")
    private String attImgUrl;

    public BeamSecurityModel() {
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public String getAttImgGuid() {
        return attImgGuid;
    }

    public void setAttImgGuid(String attImgGuid) {
        this.attImgGuid = attImgGuid;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }


}
