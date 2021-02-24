package org.tonzoc.model;

import org.tonzoc.annotation.Column;
import org.tonzoc.annotation.NotInsertColumn;
import org.tonzoc.annotation.PrimaryKey;
import org.tonzoc.annotation.Table;

// 安全隐患表
@Table("unsafes")
public class UnsafeModel extends BaseModel {

    @NotInsertColumn
    @PrimaryKey
    @Column(value = "guid")
    private String guid;
    @Column(value = "name")
    private String name; // 安全隐患名称
    @Column(value = "number")
    private String number; // 安全隐患数量
    @Column(value = "sortId")
    private String sortId;

    public UnsafeModel() {
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSortId() {
        return sortId;
    }

    public void setSortId(String sortId) {
        this.sortId = sortId;
    }

    @Override
    public String toString() {
        return "UnsafeModel{" +
                "guid='" + guid + '\'' +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", sortId='" + sortId + '\'' +
                '}';
    }
}
