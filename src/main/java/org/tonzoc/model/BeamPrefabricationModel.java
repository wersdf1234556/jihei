package org.tonzoc.model;

import org.tonzoc.annotation.*;

// 预制梁
@Table("beamPrefabrications")
public class BeamPrefabricationModel extends BaseModel{

    @PrimaryKey
    @NotInsertColumn
    @Column(value = "guid")
    private String guid;
    @Column(value = "name")
    private String name;
    @Column(value = "leftAndRight")
    private String leftAndRight; // 左右幅
    @Column(value = "span")
    private String span; // 跨
    @Column(value = "sortId")
    private Integer sortId;
    @Column(value = "attTime")
    private String attTime;
    @Column(value = "operator")
    private String operator;
    @Column(value = "tenderGuid")
    private String tenderGuid;

    @JoinColumn(value = "name", type = TenderModel.class, leftColumn = "tenderGuid", rightColumn = "guid")
    private String tenderName;

    public BeamPrefabricationModel() {
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

    public String getLeftAndRight() {
        return leftAndRight;
    }

    public void setLeftAndRight(String leftAndRight) {
        this.leftAndRight = leftAndRight;
    }

    public String getSpan() {
        return span;
    }

    public void setSpan(String span) {
        this.span = span;
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
}
