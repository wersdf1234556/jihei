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
    @Column(value = "personCount")
    private Integer personCount;
    @Column(value = "formattedName")
    private String formattedName;

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

    public Integer getPersonCount() {
        return personCount;
    }

    public void setPersonCount(Integer personCount) {
        this.personCount = personCount;
    }

    public String getFormattedName() {
        return formattedName;
    }

    public void setFormattedName(String formattedName) {
        this.formattedName = formattedName;
    }

    @Override
    public String toString() {
        return "PersonTypeModel{" +
                "guid='" + guid + '\'' +
                ", name='" + name + '\'' +
                ", sortId=" + sortId +
                ", categoryGuid='" + categoryGuid + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", colour='" + colour + '\'' +
                ", number=" + number +
                ", personCount=" + personCount +
                '}';
    }
}
