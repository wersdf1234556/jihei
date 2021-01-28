package org.tonzoc.model;

import org.tonzoc.annotation.*;

// 步骤表
@Table("steps")
public class StepModel extends BaseModel {

    @NotInsertColumn
    @PrimaryKey
    @Column(value = "name")
    private String name;
    @Column(value = "sortId")
    private Integer sortId;


    public StepModel() {
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

}
