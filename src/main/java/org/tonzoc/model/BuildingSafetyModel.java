package org.tonzoc.model;

import org.tonzoc.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
//建安费各项表
@Table("buildingSafety")
public class BuildingSafetyModel extends BaseModel{

    @PrimaryKey
    @NotInsertColumn
    @Column(value = "guid")
    private String guid;
    @Column(value = "name")
    private String name; // 名称
    @Column(value = "createdAt")
    @NotInsertColumn
    private Date createdAt;

    @Column(value = "balance")
    private BigDecimal balance;

    @Column(value = "sortId")
    private Integer sortId;

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


    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
