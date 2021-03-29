package org.tonzoc.model;

import org.tonzoc.annotation.Column;
import org.tonzoc.annotation.NotInsertColumn;
import org.tonzoc.annotation.PrimaryKey;
import org.tonzoc.annotation.Table;

@Table(value = "personCategory")
public class PersonCategoryModel extends BaseModel {
    @PrimaryKey
    @NotInsertColumn
    @Column(value = "guid")
    private String guid;
    @Column(value = "name")
    private String name; // 人员类别名称
    @Column(value = "sortId")
    private Integer sortId; // 排序
    @Column(value = "flag")
    private Integer flag;
    @Column(value = "colour")
    private String colour; //颜色
    @Column(value = "display")
    private String display;

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

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }
}
