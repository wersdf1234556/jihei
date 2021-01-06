package org.tonzoc.model;

import org.tonzoc.annotation.*;

@Table(value = "newsTypes")
public class NewsTypeModel extends BaseModel{
    @PrimaryKey
    @NotInsertColumn
    @Column(value = "guid")
    private String guid;
    @Column(value = "name")
    private String name; // 类型名称
    @Column(value = "sortId")
    private Integer sortId;
    @Column(value = "sign")
    private String sign;     //标题的唯一标识

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

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

}
