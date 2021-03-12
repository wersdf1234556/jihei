package org.tonzoc.model;

import org.tonzoc.annotation.*;

import java.util.List;

@Table(value = "personTypes")
public class PersonTypeModel extends BaseModel{
    @PrimaryKey
    @NotInsertColumn
    @Column(value = "guid")
    private String guid;
    @Column(value = "name")
    private String name; // 人员工种
    @Column(value = "sortId")
    private Integer sortId; // 排序
    @Column(value = "categoryGuid")
    private String categoryGuid;
    @JoinColumn(value = "name", type = PersonCategoryModel.class, leftColumn = "categoryGuid", rightColumn = "guid")
    private String categoryName; //人员类别
    @JoinColumn(value = "colour", type = PersonCategoryModel.class, leftColumn = "categoryGuid", rightColumn = "guid")
    private String colour; //颜色
    @Column(value = "number")
    private Integer number;

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


    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getCategoryGuid() {
        return categoryGuid;
    }

    public void setCategoryGuid(String categoryGuid) {
        this.categoryGuid = categoryGuid;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "PersonTypeModel{" +
                "guid='" + guid + '\'' +
                ", name='" + name + '\'' +
                ", sortId=" + sortId +
                ", colour='" + colour + '\'' +
                ", categoryGuid='" + categoryGuid + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", number=" + number +
                '}';
    }
}
