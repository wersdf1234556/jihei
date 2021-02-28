package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class SubTypeQueryParams {

    @Operator(value = "eq", field = "guid")
    private String guid;

    @Operator(value = "like", field = "name")
    private String name;

    @Operator(value = "eq", field = "sortId")
    private Integer sortId;

    @Operator(value = "eq", field = "typeId")
    private Integer typeId;

    @Operator(value = "eq", field = "paragraph")
    private String paragraph; // 段落

    @Operator(value = "eq", field = "parts")
    private String parts; // 部位

    @Operator(value = "eq", field = "major")
    private String major;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Integer getSortId() {
        return sortId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getParagraph() {
        return paragraph;
    }

    public void setParagraph(String paragraph) {
        this.paragraph = paragraph;
    }

    public String getParts() {
        return parts;
    }

    public void setParts(String parts) {
        this.parts = parts;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
