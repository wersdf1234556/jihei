package org.tonzoc.model;

import org.tonzoc.annotation.Column;
import org.tonzoc.annotation.NotInsertColumn;
import org.tonzoc.annotation.PrimaryKey;
import org.tonzoc.annotation.Table;

import java.math.BigDecimal;
import java.util.Date;
//投资总费用表
@Table(value = "investmentCost")
public class InvestmentCostModel extends BaseModel{
    @PrimaryKey
    @NotInsertColumn
    @Column(value = "guid")
    private String guid;
    @Column(value = "name")
    private String name; // 名称
    @Column(value = "balance")
    private BigDecimal balance;
    @Column(value = "createdAt")
    @NotInsertColumn
    private Date createdAt;
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

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
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

    @Override
    public String toString() {
        return "InvestmentCostModel{" +
                "guid='" + guid + '\'' +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", createdAt=" + createdAt +
                ", sortId=" + sortId +
                '}';
    }
}
