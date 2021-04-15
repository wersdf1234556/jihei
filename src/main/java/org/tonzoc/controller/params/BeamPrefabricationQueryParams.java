package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class BeamPrefabricationQueryParams {

    @Operator(value = "eq", field = "guid")
    private String guid;
    @Operator(value = "like", field = "name")
    private String name;
    @Operator(value = "like", field = "leftAndRight")
    private String leftAndRight; // 左右幅
    @Operator(value = "like", field = "cross")
    private String cross; // 跨
    @Operator(value = "eq", field = "guid")
    private Integer sortId;

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

    public String getCross() {
        return cross;
    }

    public void setCross(String cross) {
        this.cross = cross;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }
}
