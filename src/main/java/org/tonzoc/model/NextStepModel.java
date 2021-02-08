package org.tonzoc.model;

import org.tonzoc.annotation.*;

@Table(value = "nextSteps")
public class NextStepModel extends BaseModel {

    @NotInsertColumn
    @PrimaryKey
    @Column(value = "guid")
    private String guid;
    @Column(value = "name")
    private String name;
    @Column(value = "currentStepGuid")
    private String currentStepGuid;
    @Column(value = "nextStepGuid")
    private String nextStepGuid;
    @Column(value = "isBackward")
    private Integer isBackward;
    @Column(value = "sortId")
    private Integer sortId;

    public NextStepModel() {
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

    public String getCurrentStepGuid() {
        return currentStepGuid;
    }

    public void setCurrentStepGuid(String currentStepGuid) {
        this.currentStepGuid = currentStepGuid;
    }

    public String getNextStepGuid() {
        return nextStepGuid;
    }

    public void setNextStepGuid(String nextStepGuid) {
        this.nextStepGuid = nextStepGuid;
    }

    public Integer getIsBackward() {
        return isBackward;
    }

    public void setIsBackward(Integer isBackward) {
        this.isBackward = isBackward;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }
}
