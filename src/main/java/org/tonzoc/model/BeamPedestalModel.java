package org.tonzoc.model;

import org.tonzoc.annotation.*;

// 梁台座
@Table("beamPedestals")
public class BeamPedestalModel extends BaseModel{

    @PrimaryKey
    @NotInsertColumn
    @Column(value = "guid")
    private String guid;
    @Column(value = "name")
    private String name;
    @Column(value = "pedestalNum")
    private String pedestalNum;
    @Column(value = "sortId")
    private Integer sortId;
    @Column(value = "modelNum")
    private String modelNum;
    @Column(value = "attTime")
    private String attTime;
    @Column(value = "operator")
    private String operator;
    @Column(value = "tenderGuid")
    private String tenderGuid;
    @Column(value = "status")
    private String status; // 状态
    @Column(value = "color")
    private String color; // 颜色
    @Column(value = "textNum")
    private String textNum; // 文字编号

    @JoinColumn(value = "name", type = TenderModel.class, leftColumn = "tenderGuid", rightColumn = "guid")
    private String tenderName;

    public BeamPedestalModel() {
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

    public String getPedestalNum() {
        return pedestalNum;
    }

    public void setPedestalNum(String pedestalNum) {
        this.pedestalNum = pedestalNum;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public String getAttTime() {
        return attTime;
    }

    public void setAttTime(String attTime) {
        this.attTime = attTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
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

    public String getModelNum() {
        return modelNum;
    }

    public void setModelNum(String modelNum) {
        this.modelNum = modelNum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTextNum() {
        return textNum;
    }

    public void setTextNum(String textNum) {
        this.textNum = textNum;
    }
}
