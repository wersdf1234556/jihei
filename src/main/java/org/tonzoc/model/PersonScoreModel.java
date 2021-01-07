package org.tonzoc.model;

import org.tonzoc.annotation.*;

// 人员分数表
@Table(value = "personScores")
public class PersonScoreModel extends BaseModel{

    @NotInsertColumn
    @PrimaryKey
    @Column(value = "guid")
    private String guid;
    @Column(value = "scores")
    private Integer scores; // 分数
    @Column(value = "sortId")
    private Integer sortId;
    @Column(value = "personGuid")
    private String personGuid;
    @Column(value = "tenderGuid")
    private String tenderGuid;

    @JoinColumn(value = "name", type = PersonModel.class, leftColumn = "personGuid", rightColumn = "guid")
    private String personName;  // 人员名称
    @JoinColumn(value = "name", type = TenderModel.class, leftColumn = "tenderGuid", rightColumn = "guid")
    private String tenderName;  // 标段名称

    public PersonScoreModel() {
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Integer getScores() {
        return scores;
    }

    public void setScores(Integer scores) {
        this.scores = scores;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public String getPersonGuid() {
        return personGuid;
    }

    public void setPersonGuid(String personGuid) {
        this.personGuid = personGuid;
    }

    public String getTenderGuid() {
        return tenderGuid;
    }

    public void setTenderGuid(String tenderGuid) {
        this.tenderGuid = tenderGuid;
    }

    @Override
    public String toString() {
        return "PersonScoreModel{" +
                "guid='" + guid + '\'' +
                ", scores=" + scores +
                ", sortId=" + sortId +
                ", personGuid='" + personGuid + '\'' +
                ", tenderGuid='" + tenderGuid + '\'' +
                '}';
    }
}
