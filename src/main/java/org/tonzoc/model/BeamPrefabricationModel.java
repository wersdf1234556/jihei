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
    @Column(value = "prefabricationNum")
    private String prefabricationNum;
    @Column(value = "attTime")
    private String attTime;
    @Column(value = "operator")
    private String operator;
    @Column(value = "tenderGuid")
    private String tenderGuid;
    @Column(value = "concreteStrengthOne")
    private String concreteStrengthOne; // 混凝土强度1
    @Column(value = "concreteStrengthTwo")
    private String concreteStrengthTwo; // 混凝土强度2
    @Column(value = "concreteStrengthThree")
    private String concreteStrengthThree; // 混凝土强度3
    @Column(value = "remarks")
    private String remarks; // 备注
    @Column(value = "status")
    private String status;
    @Column(value = "color")
    private String color; // 颜色

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

    public String getConcreteStrengthOne() {
        return concreteStrengthOne;
    }

    public void setConcreteStrengthOne(String concreteStrengthOne) {
        this.concreteStrengthOne = concreteStrengthOne;
    }

    public String getConcreteStrengthTwo() {
        return concreteStrengthTwo;
    }

    public void setConcreteStrengthTwo(String concreteStrengthTwo) {
        this.concreteStrengthTwo = concreteStrengthTwo;
    }

    public String getConcreteStrengthThree() {
        return concreteStrengthThree;
    }

    public void setConcreteStrengthThree(String concreteStrengthThree) {
        this.concreteStrengthThree = concreteStrengthThree;
    }

    public String getPrefabricationNum() {
        return prefabricationNum;
    }

    public void setPrefabricationNum(String prefabricationNum) {
        this.prefabricationNum = prefabricationNum;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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
}
