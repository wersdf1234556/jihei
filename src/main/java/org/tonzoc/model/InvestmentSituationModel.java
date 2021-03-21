package org.tonzoc.model;

import org.tonzoc.annotation.*;

import java.math.BigDecimal;
import java.util.Date;

//项目办录入的投资情况表
@Table(value = "investmentSituation")
public class InvestmentSituationModel extends BaseModel{
    @PrimaryKey
    @NotInsertColumn
    @Column(value = "guid")
    private String guid;
    @Column(value = "investmentCostGuid")
    private String investmentCostGuid; // 投资项目
    @JoinColumn(value = "name", type = InvestmentCostModel.class, leftColumn = "investmentCostGuid", rightColumn = "guid")
    private String investmentCostName; //投资项目名称
    @Column(value = "balance")
    private BigDecimal balance;
    @Column(value = "date")
    private String date;
    @Column(value = "createdAt")
    @NotInsertColumn
    private Date createdAt;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getInvestmentCostGuid() {
        return investmentCostGuid;
    }

    public void setInvestmentCostGuid(String investmentCostGuid) {
        this.investmentCostGuid = investmentCostGuid;
    }

    public String getInvestmentCostName() {
        return investmentCostName;
    }

    public void setInvestmentCostName(String investmentCostName) {
        this.investmentCostName = investmentCostName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
