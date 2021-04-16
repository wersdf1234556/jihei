package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class BeamPrefabricationQueryParams {

    @Operator(value = "eq", field = "guid")
    private String guid;
    @Operator(value = "like", field = "name")
    private String name;
    @Operator(value = "like", field = "leftAndRight")
    private String leftAndRight; // 左右幅
    @Operator(value = "like", field = "span")
    private String span; // 跨
    @Operator(value = "eq", field = "guid")
    private Integer sortId;
    @Operator(value = "like", field = "attTime")
    private String attTime;
    @Operator(value = "eq", field = "tenderGuid")
    private String tenderGuid;

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

    public String getTenderGuid() {
        return tenderGuid;
    }

    public void setTenderGuid(String tenderGuid) {
        this.tenderGuid = tenderGuid;
    }
}
