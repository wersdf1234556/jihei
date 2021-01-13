package org.tonzoc.model;

import org.tonzoc.annotation.*;

// 步骤表
@Table("steps")
public class StepModel extends BaseModel {

    @NotInsertColumn
    @PrimaryKey
    @Column(value = "name")
    private String name;
    @Column(value = "stepTypeGuid")
    private String stepTypeGuid;
    @Column(value = "sortId")
    private Integer sortId;

    @JoinColumn(value = "name", type = StepTypeModel.class, leftColumn = "stepTypeGuid", rightColumn = "guid")
    private String stepTypeName;  // 步骤类型名称

    public StepModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStepTypeGuid() {
        return stepTypeGuid;
    }

    public void setStepTypeGuid(String stepTypeGuid) {
        this.stepTypeGuid = stepTypeGuid;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public String getStepTypeName() {
        return stepTypeName;
    }

    public void setStepTypeName(String stepTypeName) {
        this.stepTypeName = stepTypeName;
    }
}
