package org.tonzoc.model;

import org.tonzoc.annotation.Column;
import org.tonzoc.annotation.NotInsertColumn;
import org.tonzoc.annotation.PrimaryKey;
import org.tonzoc.annotation.Table;

// 分数规则表
@Table(value = "securityRules")
public class SecurityRuleModel extends BaseModel {

    @NotInsertColumn
    @PrimaryKey
    @Column(value = "guid")
    private String guid;
    @Column(value = "name")
    private String name; // 检查项目
    @Column(value = "rules")
    private String rules; // 分值说明
    @Column(value = "defaultScore")
    private Integer defaultScore; // 默认分数
    @Column(value = "sortId")
    private Integer sortId;

    public SecurityRuleModel() {
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDefaultScore() {
        return defaultScore;
    }

    public void setDefaultScore(Integer defaultScore) {
        this.defaultScore = defaultScore;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    @Override
    public String toString() {
        return "SecurityRuleModel{" +
                "guid='" + guid + '\'' +
                ", name='" + name + '\'' +
                ", rules='" + rules + '\'' +
                ", defaultScore=" + defaultScore +
                ", sortId=" + sortId +
                '}';
    }
}
