package org.tonzoc.model;

import org.tonzoc.annotation.*;

@Table(value = "stepPersons")
public class StepPersonModel extends BaseModel {

    @NotInsertColumn
    @PrimaryKey
    @Column(value = "guid")
    private String guid;
    @Column(value = "stepGuid")
    private String stepGuid;
    @Column(value = "personGuid")
    private String personGuid;
    @Column(value = "sortId")
    private Integer sortId;

    @JoinColumn(value = "name", type = StepModel.class, leftColumn = "stepGuid", rightColumn = "guid")
    private String stepName; //步骤名称
    @JoinColumn(value = "name", type = PersonModel.class, leftColumn = "personGuid", rightColumn = "guid")
    private String personName; //人员名称

    public StepPersonModel() {
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getStepGuid() {
        return stepGuid;
    }

    public void setStepGuid(String stepGuid) {
        this.stepGuid = stepGuid;
    }

    public String getPersonGuid() {
        return personGuid;
    }

    public void setPersonGuid(String personGuid) {
        this.personGuid = personGuid;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public String getStepName() {
        return stepName;
    }

    public void setStepName(String stepName) {
        this.stepName = stepName;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }
}
